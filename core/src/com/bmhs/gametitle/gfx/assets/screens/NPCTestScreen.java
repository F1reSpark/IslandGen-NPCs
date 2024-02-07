package com.bmhs.gametitle.gfx.assets.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.MathUtils;
import com.bmhs.gametitle.game.assets.characters.NonPlayerCharacter;
import com.bmhs.gametitle.game.utils.GameHandler;
import com.badlogic.gdx.utils.Array;
import com.bmhs.gametitle.gfx.assets.tiles.Tile;
import com.bmhs.gametitle.gfx.assets.tiles.statictiles.WorldTile;
import com.bmhs.gametitle.gfx.utils.TileHandler;

public class NPCTestScreen implements Screen {

    GameHandler game;
    Screen parent;
    Array<NonPlayerCharacter> npcVillage;
    int npcCount = 30;

    public NPCTestScreen(GameHandler game, Screen parent){
        this.game = game;
        this.parent = parent;

        npcVillage = new Array<>();


        for (int i = 0; i < npcCount; i++){
            WorldTile tempTile = TileHandler.getTileHandler().getWorldTileArray().get(3);
            float tempX = (float) (Math.random()* Gdx.graphics.getWidth());
            float tempY = (float) (Math.random()* Gdx.graphics.getHeight());
            String tempName = "NPC " + i;
            npcVillage.add(new NonPlayerCharacter(tempTile, tempY, tempX, tempName));
        }
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.batch.begin();


        for(int i = 0; i < npcCount; i++){
            NonPlayerCharacter tempChar = npcVillage.get(i);
            tempChar.tickTree();
            game.batch.draw(tempChar.getTile().getTexture(), tempChar.getX(), tempChar.getY());
        }

        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
