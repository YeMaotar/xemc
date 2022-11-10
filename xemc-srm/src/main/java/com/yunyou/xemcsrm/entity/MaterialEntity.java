package com.yunyou.xemcsrm.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("bd_material")
public class MaterialEntity implements Serializable {
    private String classcode;
    private String code;
    private String enablestate;
    private String measdoc;
    private String name;
    private String pk;
    @TableField("materialspec")
    private String materialspec;
    private String ts;
    @TableField("materialtype")
    private String materialtype;
}
