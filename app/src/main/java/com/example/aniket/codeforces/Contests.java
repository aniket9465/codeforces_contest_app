package com.example.aniket.codeforces;

public class Contests
{
    private result[] result;

    private String status;

    public result[] getResult ()
    {
        return result;
    }

    public void setResult (result[] result)
    {
        this.result = result;
    }

    public String getStatus ()
    {
        return status;
    }

    public void setStatus (String status)
    {
        this.status = status;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [result = "+result+", status = "+status+"]";
    }
}
