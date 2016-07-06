package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import sprites.Cat;

public class MotionDemo extends ApplicationAdapter {
	public static final int WIDTH = 800;
	public static final int HEIGHT = 480;
	SpriteBatch batch;
	OrthographicCamera cam;
	private float yTilt;
	private int direction; //0 is not moving, 1 is right 2 is left
	Cat cat;
	
	@Override
	public void create () {
		cam = new OrthographicCamera();
		cam.setToOrtho(false, WIDTH/3, HEIGHT/3);
		batch = new SpriteBatch();
        direction = 2;
		yTilt = Gdx.input.getAccelerometerY();
        cat = new Cat(50, 3, direction);
	}

	@Override
	public void render () {

		batch.setProjectionMatrix(cam.combined);
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		//yTilt = Gdx.input.getAccelerometerY();


        if(yTilt > 0.5){
			direction = 1;
			System.out.println(direction);
		}else if(yTilt < -0.5){
			direction = 2;
			System.out.println(direction);
		}
		cat.update(Gdx.graphics.getDeltaTime(), direction);

		batch.begin();
        batch.draw(cat.getCat(), cat.getPosition().x, cat.getPosition().y);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();

	}
}
