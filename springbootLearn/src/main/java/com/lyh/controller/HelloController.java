package com.lyh.controller;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.Map;

/**
 * Created by lvyanghui
 * 2019/2/24 17:20
 */
@RestController
@RequestMapping("/boot")
public class HelloController {

    @GetMapping("/get")
    public String get(){
        return "hello world!";
    }

    @GetMapping("/get1")
    public String get1(@RequestParam("text") String text){
        return "hello world!" + text;
    }

    @GetMapping("/get2")
    public String get2(@RequestParam("file") MultipartFile file){
        return "hello world!" + file.getOriginalFilename();
    }

    @GetMapping("/get3")
    public String get3( String text){
        return "hello world!" + text;
    }

    @GetMapping(value = "/getBinary")
    public String getBinary( HttpServletRequest request) {

        try {
            File file = new File("G:\\备份\\binary.txt");
            FileOutputStream out = new FileOutputStream(file);
            FileCopyUtils.copy(request.getInputStream(),out);
        } catch (IOException e) {

        }
        return "getBinary";
    }

    @GetMapping(value = "/getFile")
    public String getFile(MultipartFile file) {


        return "getFile fileName " + file.getOriginalFilename();
    }

    @GetMapping(value = "/getRawText")
    public String getRawText(HttpServletRequest request) {


        String result = "";
        try {
            InputStream inputStream = request.getInputStream();
            ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];

            int len;
            while ((len = inputStream.read(buffer)) != -1) {
                outSteam.write(buffer, 0, len);
            }

            outSteam.close();
            inputStream.close();

            result = new String(outSteam.toByteArray(), "UTF-8");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @GetMapping(value = "/getRawJson")
    public String getRawJson(@RequestBody Map<String,String> params) {


        String id = params.get("id");
        String name = params.get("name");
        return "hello world" + id + name;
    }

    @PostMapping(value = "/post")
    public String post(@RequestParam("text") String text){
        return "hello world!" + text;
    }

    @PostMapping(value = "/post1")
    public String post1( String text){
        return "hello world!" + text;
    }

    @PostMapping(value = "/post2")
    public String post2( String text){

        return "hello world!" + text;
    }


    @PostMapping(value = "/postBinary")
    public String postBinary(HttpServletRequest request) {

        try {
            File file = new File("G:\\备份\\binary.txt");
            FileOutputStream out = new FileOutputStream(file);
            FileCopyUtils.copy(request.getInputStream(),out);
        } catch (IOException e) {

        }
        return "postBinary";
    }

    @PostMapping(value = "/postFile")
    public String postFile(MultipartFile file) {


        return "postFile fileName " + file.getOriginalFilename();
    }

    @PostMapping(value = "/postRawText")
    public String postRawText(@RequestBody String result) {

        return result;
    }
}
