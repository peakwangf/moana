package com.peakwang.model;

import javax.jdo.annotations.*;
import java.util.Date;

@PersistenceCapable(table = "movieticket")
public class MovieTicket {

	/**
     * 电影票编号
     */
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private int tid;
    /**
     * 电影名称
     */
    private String movieName;
    /**
     * 剩余数量
     */
    private int ticketNum;
    /**
     * 放映时间
     */
    public Date runTime;
    
    public MovieTicket(){
    	
    }
    public int getTid() {
        return tid;
    }

    public void setTid(int id) {
        this.tid = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getTicketNum() {
        return ticketNum;
    }

    public void setTicketNum(int ticketNum) {
        this.ticketNum = ticketNum;
    }
    
    public Date getRunTime() {
        return runTime;
    }

    public void setRunTime(Date runTime) {
        this.runTime = runTime;
    }
}
