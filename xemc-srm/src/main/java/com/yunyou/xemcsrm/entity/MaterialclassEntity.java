package com.yunyou.xemcsrm.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Objects;

@TableName("bd_materialclass")
public class MaterialclassEntity implements Serializable {
    private String classcode;
    private String code;
    private String enablestate;
    private String name;
    @TableId
    private String pk;
    private String ts;

    public String getClasscode() {
        return classcode;
    }

    public void setClasscode(String classcode) {
        this.classcode = classcode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEnablestate() {
        return enablestate;
    }

    public void setEnablestate(String enablestate) {
        this.enablestate = enablestate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPk() {
        return pk;
    }

    public void setPk(String pk) {
        this.pk = pk;
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MaterialclassEntity that = (MaterialclassEntity) o;
        return Objects.equals(classcode, that.classcode) && Objects.equals(code, that.code) && Objects.equals(enablestate, that.enablestate) && Objects.equals(name, that.name) && Objects.equals(pk, that.pk) && Objects.equals(ts, that.ts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(classcode, code, enablestate, name, pk, ts);
    }

    @Override
    public String toString() {
        return "MaterialclassEntity{" +
                "classcode='" + classcode + '\'' +
                ", code='" + code + '\'' +
                ", enablestate='" + enablestate + '\'' +
                ", name='" + name + '\'' +
                ", pk='" + pk + '\'' +
                ", ts='" + ts + '\'' +
                '}';
    }
}
