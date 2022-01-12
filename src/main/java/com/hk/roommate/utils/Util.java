// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Util.java

package com.hk.roommate.utils;


public class Util
{
  
    public Util()
    {
    }

    public String getArrow()
    {
        return arrow;
    }

    public void setArrow(String depth)
    {
        String nbsp = "";
        int depthInt = Integer.parseInt(depth);
        for(int i = 0; i < depthInt; i++)
            nbsp = (new StringBuilder(String.valueOf(nbsp))).append("&nbsp;&nbsp;&nbsp;&nbsp;").toString();

        arrow = (new StringBuilder(String.valueOf(nbsp))).append(depthInt <= 0 ? "" : "<img width='10px;' height='10px;' src='img/arrow.png'/>").toString();
    }

    private String arrow;
}
