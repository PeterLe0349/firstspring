package com.codeup.firstspring.Models;
import com.mysql.cj.protocol.ColumnDefinition;

import javax.persistence.*;

import javax.persistence.Entity;

@Entity
public class Numero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(columnDefinition="INT(11) UNSIGNED")
    private long unsignnum;

    @Column
    private int intn;

    @Column private byte bytn;

    @Column private short shortn;

    @Column private long longn;

    @Column
    private float floatn;

    public Numero(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getIntn() {
        return intn;
    }

    public void setIntn(int intn) {
        this.intn = intn;
    }

    public byte getBytn() {
        return bytn;
    }

    public void setBytn(byte bytn) {
        this.bytn = bytn;
    }

    public long getLongn() {
        return longn;
    }

    public void setLongn(long longn) {
        this.longn = longn;
    }

    public float getFloatn() {
        return floatn;
    }

    public void setFloatn(float floatn) {
        this.floatn = floatn;
    }
}
