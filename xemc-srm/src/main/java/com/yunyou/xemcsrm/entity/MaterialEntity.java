package com.yunyou.xemcsrm.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Objects;

@TableName("bd_material")
public class MaterialEntity implements Serializable {
    private String classcode;
    private String code;
    private String enablestate;
    private String measdoc;
    private String name;
    private String pk;
    private String materialspec;
    private String ts;
    private String materialtype;

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

    public String getMeasdoc() {
        return measdoc;
    }

    public void setMeasdoc(String measdoc) {
        this.measdoc = measdoc;
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

    public String getMaterialSpec() {
        return materialspec;
    }

    public void setMaterialSpec(String materialspec) {
        this.materialspec = materialspec;
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public String getMaterialType() {
        return materialtype;
    }

    public void setMaterialType(String materialtype) {
        this.materialtype = materialtype;
    }

    @Override
    public int hashCode() {
        return Objects.hash(classcode, code, enablestate, measdoc, name, pk, materialspec, ts, materialtype);
    }

    @Override
    public String toString() {
        return "MaterialEntity{" +
                "classcode='" + classcode + '\'' +
                ", code='" + code + '\'' +
                ", enablestate='" + enablestate + '\'' +
                ", measdoc='" + measdoc + '\'' +
                ", name='" + name + '\'' +
                ", pk='" + pk + '\'' +
                ", materialspec='" + materialspec + '\'' +
                ", ts='" + ts + '\'' +
                ", materialtype='" + materialtype + '\'' +
                '}';
    }
}
