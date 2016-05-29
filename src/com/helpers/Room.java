/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helpers;

/**
 *
 * @author Turna
 */
public class Room {

    public String RoomLocation;
    public String newRoom;
    public String newUID;
    public String lastRoom;
    public String lastUID;

    public String getNewUID() {
        return newUID;
    }

    public void setNewUID(String newUID) {
        this.newUID = newUID;
    }

    public String getLastUID() {
        return lastUID;
    }

    public void setLastUID(String lastUID) {
        this.lastUID = lastUID;
    }
    
    public String getRoomLocation() {
        return RoomLocation;
    }

    public void setRoomLocation(String RoomLocation) {
        this.RoomLocation = RoomLocation;
    }

    public String getNewRoom() {
        return newRoom;
    }

    public void setNewRoom(String newRoom) {
        this.newRoom = newRoom;
    }

    public String getLastRoom() {
        return lastRoom;
    }

    public void setLastRoom(String lastRoom) {
        this.lastRoom = lastRoom;
    }
}
