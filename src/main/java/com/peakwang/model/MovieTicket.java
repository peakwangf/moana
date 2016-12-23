package com.peakwang.model;

import javax.jdo.annotations.*;

@PersistenceCapable(table = "movieticket")
public class MovieTicket {

	/**
     * 电影票编号
     */
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private int tId;
    /**
     * 电影名称
     */
    private String movieName;
    /**
     * 剩余数量
     */
    private int ticketNum;
    
    public int getTId() {
        return tId;
    }

    public void setTId(int tId) {
        this.tId = tId;
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

}
