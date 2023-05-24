package com.htn.myblog.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "posts")
public class Posts {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "remark")
    private String remark;

    @Column(name = "order")
    private Long order;

    @Column(name = "parent_id")
    private Long parentId;

    @Column(name = "use_flag")
    private String useFlag;

    @Column(name = "reg_id")
    private Long regId;

    @Column(name = "reg_dt")
    private Date regDt;

    @Column(name = "edit_id")
    private Long editId;

    @Column(name = "edit_dt")
    private Date editDt;
}
