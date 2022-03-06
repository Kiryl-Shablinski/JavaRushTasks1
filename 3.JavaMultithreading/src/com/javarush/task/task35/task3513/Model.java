package com.javarush.task.task35.task3513;

import java.util.*;

public class Model {
    private static final int FIELD_WIDTH = 4;
   private   Tile[][] gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
    int score;
    int maxTile;
    private Stack<Tile[][]> previousStates;
    private Stack<Integer> previousScores;
    private boolean isSaveNeeded = true;

    public Model(){
       resetGameTiles();
       previousScores = new Stack<>();
       previousStates = new Stack<>();
    }

    public void autoMove(){
        PriorityQueue<MoveEfficiency> priorityQueue = new PriorityQueue<>(4,Collections.reverseOrder());
        priorityQueue.offer(getMoveEfficiency(this::left));
        priorityQueue.offer(getMoveEfficiency(this::right));
        priorityQueue.offer(getMoveEfficiency(this::down));
        priorityQueue.offer(getMoveEfficiency(this::up));

        priorityQueue.peek().getMove().move();

    }


    public boolean hasBoardChanged(){
          Tile[][] tmpTiles = previousStates.peek();
           for (int i = 0; i < gameTiles.length; i++){
               for (int j = 0; j < gameTiles[i].length; j++){
                   if (gameTiles[i][j].value != tmpTiles[i][j].value) return true;
               }
           }
        return false;
    }

    private MoveEfficiency getMoveEfficiency(Move move){
        move.move();
        MoveEfficiency moveEfficiency =  new MoveEfficiency(getEmptyTiles().size(),score,move);
        if (!hasBoardChanged()){
            moveEfficiency = new MoveEfficiency(-1, 0, move);
        }
        rollback();
        return moveEfficiency;
    }


    public void randomMove(){
        saveState(gameTiles);
        int n = ((int)(Math.random() * 100)) % 4;

        switch (n){
            case 0 : left();
            break;
            case 1 : down();
            break;
            case 2 : right();
            break;
            case 3 : up();
            break;
        }


    }

    private void saveState(Tile[][] tiles){
        Tile[][] stackTile = new Tile[gameTiles.length][gameTiles.length];
        for (int i = 0; i < stackTile.length; i++){
            for (int j = 0; j < stackTile[i].length; j++){
                stackTile[i][j] = new Tile(tiles[i][j].value);
            }
        }
        int stackScore = score;
        previousStates.push(stackTile);
        previousScores.push(stackScore);
        isSaveNeeded = false;
    }

    public void rollback(){
        if (!previousScores.isEmpty() && !previousStates.isEmpty()) {
            gameTiles = previousStates.pop();
            score = previousScores.pop();
        }
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }

    public boolean canMove(){
        for (int i = 0; i < gameTiles.length; i++){
            for (int j = 0; j < gameTiles[i].length; j++){
                if (gameTiles[i][j].isEmpty()) return true;
                if (i < gameTiles.length-1 && gameTiles[i][j].value == gameTiles[i+1][j].value) return true;
                if ( j < gameTiles[i].length-1 && gameTiles[i][j].value == gameTiles[i][j + 1].value) return true;
            }
        }
        return false;
    }

    private List<Tile> getEmptyTiles(){
        List<Tile> emptyTiles = new ArrayList<>();
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles[i].length; j++){
               if(gameTiles[i][j].isEmpty()){
                   emptyTiles.add(gameTiles[i][j]);
               }
            }
        }
        return emptyTiles;
    }

    private void addTile(){
        List<Tile> emptyTiles = getEmptyTiles();
        if(emptyTiles.isEmpty()) return;
            emptyTiles.get((int) (emptyTiles.size() * Math.random())).value = (int) (Math.random() < 0.9 ? 2 : 4);


    }

    public void resetGameTiles(){
        for (int i = 0; i < gameTiles.length; i++){
            for (int j = 0; j < gameTiles[i].length; j++){
                gameTiles[i][j] = new Tile();
            }
        }
        score = 0;
        maxTile = 0;
        addTile();
        addTile();
    }

    private boolean compressTiles (Tile[] tiles){
     int hash = Arrays.hashCode(tiles);
     Arrays.sort(tiles, Comparator.comparing(Tile::isEmpty));
    
      return hash != Arrays.hashCode(tiles);
    }

    private   boolean mergeTiles (Tile[] tiles){
        boolean change = false;
        for (int i = 0; i < tiles.length-1; i++){
            if (tiles[i].value == tiles[i+1].value && !tiles[i].isEmpty()){
                tiles[i].value *= 2;
                tiles[i +1].value = 0;
                score += tiles[i].value;
                change = true;
                if (maxTile < tiles[i].value){
                    maxTile = tiles[i].value;
                }
            }
            compressTiles(tiles);
        }
        return change;
    }

    public void left (){
        if (isSaveNeeded) {
            saveState(gameTiles);
        }

            boolean moveFlag = false;
            for (int i = 0; i < gameTiles.length; i++) {
                if (compressTiles(gameTiles[i]) | mergeTiles(gameTiles[i]) & !getEmptyTiles().isEmpty()) {
                    moveFlag = true;
                }
            }
       if (moveFlag) addTile();
         isSaveNeeded = true;

    }

    public void down(){
        saveState(gameTiles);
        rotationTile();
        left();
        rotationTile();
        rotationTile();
        rotationTile();
    }
    public void right(){
        saveState(gameTiles);
        rotationTile();
        rotationTile();
        left();
        rotationTile();
        rotationTile();
    }

    public void up(){
        saveState(gameTiles);
        rotationTile();
        rotationTile();
        rotationTile();
        left();
        rotationTile();
    }

    private void rotationTile(){
        int arraySize = gameTiles.length;
        Tile[][] rotationTiles = new Tile[arraySize][arraySize];
        for (int i = 0; i < gameTiles.length; i++){
            for (int j = 0; j < gameTiles[i].length; j++){
                rotationTiles[j][arraySize-1-i] = gameTiles[i][j];
            }
        }
        gameTiles =Arrays.copyOf(rotationTiles,rotationTiles.length);
    }
}
