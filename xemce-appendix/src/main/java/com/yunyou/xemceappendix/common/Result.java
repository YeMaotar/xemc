package com.yunyou.xemceappendix.common;

import lombok.*;

/**
 * @title: Result
 * @Author ZhangZw
 * @Date: 2022/4/25 15:38
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Result {
    private int code;
    private String message;
    private Object data;
    private String fileUrl;
    private String previewUrl;
}
