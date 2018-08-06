package com.example.aniket.codeforces;
public class result
{
    private String id;

    private String relativeTimeSeconds;

    private String startTimeSeconds;

    private String durationSeconds;

    private String name;

    private String frozen;

    private String type;

    private String phase;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getRelativeTimeSeconds ()
    {
        return relativeTimeSeconds;
    }

    public void setRelativeTimeSeconds (String relativeTimeSeconds)
    {
        this.relativeTimeSeconds = relativeTimeSeconds;
    }

    public String getStartTimeSeconds ()
    {
        return startTimeSeconds;
    }

    public void setStartTimeSeconds (String startTimeSeconds)
    {
        this.startTimeSeconds = startTimeSeconds;
    }

    public String getDurationSeconds ()
    {
        return durationSeconds;
    }

    public void setDurationSeconds (String durationSeconds)
    {
        this.durationSeconds = durationSeconds;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getFrozen ()
    {
        return frozen;
    }

    public void setFrozen (String frozen)
    {
        this.frozen = frozen;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    public String getPhase ()
    {
        return phase;
    }

    public void setPhase (String phase)
    {
        this.phase = phase;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", relativeTimeSeconds = "+relativeTimeSeconds+", startTimeSeconds = "+startTimeSeconds+", durationSeconds = "+durationSeconds+", name = "+name+", frozen = "+frozen+", type = "+type+", phase = "+phase+"]";
    }
}
