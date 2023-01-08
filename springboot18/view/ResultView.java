package com.example.springboot18.view;
//
//import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ResultView<T> {

    private final static Integer DEFAULT_CODE = 1000;

//    @ApiModelProperty("状态码")
    private Integer code = 200;

    private String msg = "操作成功";

    private T data;

    private Long total;

    public static ResultView success() {
        ResultView view = new ResultView();
        return view;
    }

    public static ResultView success(Object object) {
        ResultView view = new ResultView();
        view.setData(object);
        return view;
    }

    public static ResultView success(Object object,Long total) {
        ResultView view = new ResultView();
        view.setData(object);
        view.setTotal(total);
        return view;
    }

    public static ResultView fail(Integer code, String msg) {
        ResultView view = new ResultView();
        view.setCode(code);
        view.setMsg(msg);
        return view;
    }

    public static ResultView fail(Integer code) {
        ResultView view = new ResultView();
        view.setCode(code);
        view.setMsg("系统错误!");
        return view;
    }

    public static ResultView fail() {
        ResultView view = new ResultView();
        view.setCode(DEFAULT_CODE);
        view.setMsg("系统错误!");
        return view;
    }

    public static ResultView fail(String msg) {
        ResultView view = new ResultView();
        view.setCode(DEFAULT_CODE);
        view.setMsg(msg);
        return view;
    }


}
