package com.company.board;

import com.company.common.file;
import com.company.common.location;
import com.company.pieces.piece;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.LinkedList;

public class Board {
    private static LinkedList<piece> ps = new LinkedList<>();
    private static LinkedList<location> position = new LinkedList<>();

    public static void main(String[] args) throws IOException {



        JFrame frame = new JFrame();
        frame.setUndecorated(true);
        frame.setBounds(10, 10, 512, 512); //creates window and sets the boundaries

        JPanel pn = new JPanel() {
            @Override
            public void paint(Graphics g) {

                boolean white = true;
                for (int x = 0; x < 8; x++) { //loops through both x and y-axis and uses boolean
                    for (int y = 0; y < 8; y++) {//to set square to black of white depending on the boolean
                        //Sets the background colours of the board
                        if (white) {
                            g.setColor(new Color(232, 235, 239));
                        } else {
                            g.setColor(new Color(125, 135, 150));
                        }
                        g.fillRect(x * 64, y * 64, 64, 64);
                        white = !white;

                        boolean piecePlaced = checkStartLocations(x, y);

                        if (piecePlaced) {


                        }
                    }
                    white = !white;
                }
            }
        };


        frame.add(pn);
        frame.setDefaultCloseOperation(3); //enables you to close the tab
        frame.setVisible(true);


    }

    private static boolean checkStartLocations(int x, int y) {
        //file.values()[x] this bit sets the A,B,C.... bit of the chess piece using the file enums
        location tempLocation = new location(file.values()[x], y + 1);
        boolean piecePlaced = false;

        //Checks if piece is in the right starting location, if not, will not make a new piece
        //if (x==1 y ==1){ DO a series of if statements for each of your chess pieces, if they are in the right location, set a piece and add it to list

        piece wKing = new piece(tempLocation.getColumn(), tempLocation.getRow(), true, "king", ps, "com/company/res/white/king.png");
        tempLocation.setPieces(wKing);
        piecePlaced = true;


        if (x == 0 || y == 0) {
            piece bRook = new piece(tempLocation.getColumn(), tempLocation.getRow(), false, "rook", ps, "com/company/res/black/rook.png");
            tempLocation.setPicture(new JLabel(bRook.getFileLocation())); //CHECK
            tempLocation.setPieces(bRook);
            piecePlaced = true;
        }
        if (x == 7 || y == 0) {
            piece bRook = new piece(tempLocation.getColumn(), tempLocation.getRow(), false, "rook", ps, "com/company/res/black/rook.png");
            tempLocation.setPicture(new JLabel(bRook.getFileLocation())); //CHECK
            tempLocation.setPieces(bRook);
            piecePlaced = true;
        }
        if (x == 1 || y == 0) {
            piece bKnight = new piece(tempLocation.getColumn(), tempLocation.getRow(), false, "knight", ps, "com/company/res/black/knight");
            tempLocation.setPicture(new JLabel(bKnight.getFileLocation())); //CHECK
            tempLocation.setPieces(bKnight);
            piecePlaced = true;
        }
        if (x == 6 || y == 0) {
            piece bKnight = new piece(tempLocation.getColumn(), tempLocation.getRow(), false, "knight", ps, "com/company/res/black/knight");
            tempLocation.setPicture(new JLabel(bKnight.getFileLocation())); //CHECK
            tempLocation.setPieces(bKnight);
            piecePlaced = true;
        }
        if (x == 2 || y == 0) {
            piece bBishop = new piece(tempLocation.getColumn(), tempLocation.getRow(), false, "bishop", ps, "com/company/res/black/bishop");
            tempLocation.setPicture(new JLabel(bBishop.getFileLocation())); //CHECK
            tempLocation.setPieces(bBishop);
            piecePlaced = true;
        }





        position.add(tempLocation);
        return piecePlaced; //Returns true if we added a piece to the location square
    }


}
