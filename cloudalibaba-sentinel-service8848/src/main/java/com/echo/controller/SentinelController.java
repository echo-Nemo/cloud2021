package com.echo.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
public class SentinelController {

    @GetMapping("/testA")
    public String testA() {
        return " I am testA";
    }

    @GetMapping("/testB")
    public String testB() {
        return " I am testB";
    }

    @GetMapping("/testD")
    public String testD() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("testD 测试 RT");
        return " I am testD";
    }

    @GetMapping("/testE")
    public String testE() {
        log.info("testE 测试 异常比例");
        int index = 10 / 0;
        return " I am testEe";
    }

    @GetMapping("/testF")
    public String testF() {
        log.info("testF 测试 异常数");
        int index = 10 / 0;
        return " I am testF";
    }

    /*
    对热点参数进行限流 参数的类型只支持 基本数据类型和String类型
    在sentinel的热点规则中 设置资源的名称 为@SentinelResource的value的值
    //    @SentinelResource(value = "hotKey")      // 这个方式不指定 降级的方法，异常直接在前端进行展示
     */
    @GetMapping("/hotKey")
    @SentinelResource(value = "hotKey", blockHandler = "deal_hotkey")
    public String hotKey(@RequestParam(value = "p1", required = false) String p1, @RequestParam(value = "p2", required = false) String p2) {
        return " I am hotkey";
    }


    /*
    参数p1为特定值时的阈值和其它参数的阈值不一样，这里设置p1="5"时的阈值 到200后才对p1进行降级处理,单p1的值不等于5时，阈值 为原来设置的值
     */
    @GetMapping("/singleSpeHotKey")
    @SentinelResource(value = "singleSpeHotKey", blockHandler = "deal_singleSpeHotKey")
    public String singleSpeHotKey(@RequestParam(value = "p1", required = false) int p1, @RequestParam(value = "p2", required = false) String p2) {
        /*
        SentinelResource 只处理配置的异常，运行时的异常，SentinelResource不处理
         */
       // int index = 10 / 0;
        return " I am singleSpeHotKey";
    }

    public String deal_singleSpeHotKey(int p1, String p2, BlockException blockException) {
        return " I am deal_hotkey";
    }

    public String deal_hotkey(String p1, String p2, BlockException blockException) {
        return " I am deal_hotkey";
    }

}
