package com.htn.myblog.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.type.TypeReference;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class PostsDTO {
    private static final long serialVersionUID = 1L;
    public static final Type TYPE = new TypeReference<List<PostsDTO>>() {
    }.getType();

    @ApiModelProperty("id")
    private Long id;
    @ApiModelProperty("tieu de")
    private String title;
    @ApiModelProperty("noi dung")
    private String content;
    @ApiModelProperty("mo to")
    private String remark;
    @ApiModelProperty("thu tu")
    private Long order;
    @ApiModelProperty("parent Id")
    private Long parentId;
    @ApiModelProperty("use flag")
    private String useFlag;

    @ApiModelProperty("nguoi tao")
    private Long regId;
    @ApiModelProperty("ngay tao")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    @Builder.Default
    private Date regDt = new Date();

    @ApiModelProperty("nguoi sua")
    private Long editId;
    @ApiModelProperty("ngay sua")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    @Builder.Default
    private Date editDt = new Date();
}
