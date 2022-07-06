package com.company.pieces; //Contain functions to move any piece

import com.company.common.file;

import java.util.LinkedList;

public class piece {
    file column;
    Integer row;
    boolean isWhite;
    LinkedList<piece> ps;//Linked list will store a pieces functions
    String name;
    String fileLocation;



    public piece(file xp, int yp, boolean isWhite, String n, LinkedList<piece> ps, String fileLocation) {
        this.column = xp; //get the x and y values of each piece. x and y-values have a boundary of 1-8 for Y and A-H on for X
        this.row = yp;
        this.isWhite = isWhite;
        this.ps=ps;
        this.fileLocation = fileLocation;
        name = n;
        ps.add(this);
    }

    public void move(file xp, int yp) {
        for (piece p : ps) {
            if (p.column == xp && p.row == yp) {  //if the piece move is moved into the same position as another piece it will call on the kill method
                p.kill();
            }
        }
        this.column = xp; //moves the piece after attacking or moving
        this.row = yp;

    }


    public void kill() {
        ps.remove(this); //if a piece is killed its removed off the board
    }

    public String getFileLocation() {
        return fileLocation;
    }
}
