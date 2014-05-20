package com.me.mygdxgame;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class MyGdxGame implements ApplicationListener {
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private Texture texture;
	private Sprite sprite;
	Stage stage;
	Image figura;
	Image figura1;
	Image figura2;
	boolean izquierda=false;
	
	@Override
	public void create() {		
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		
	//	camera = new OrthographicCamera(1, h/w);
		//batch = new SpriteBatch();
		
		texture = new Texture(Gdx.files.internal("data/estrella.png"));
		texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		TextureRegion region = new TextureRegion(texture, 0, 0, 512, 275);
		
		//sprite = new Sprite(region);
		//sprite.setSize(0.9f, 0.9f * sprite.getHeight() / sprite.getWidth());
		//sprite.setOrigin(sprite.getWidth()/2, sprite.getHeight()/2);
		//sprite.setPosition(-sprite.getWidth()/2, -sprite.getHeight()/2);
		
	
		stage = new Stage();
		figura = new Image(region);
		figura1 = new Image(new Texture(Gdx.files.internal("data/estrella.png")));
		figura2 = new Image(new Texture(Gdx.files.internal("data/triangulo.png")));
		
		figura1.setX(500);
		figura1.setY(150);
		
		
	//image.setRotation(45);
		// image.setX(50);
		//image.getRight();
		stage.addActor(figura1);
		stage.addActor(figura2);
	}

	@Override
	public void dispose() {
		//batch.dispose();
		texture.dispose();
	}

	@Override
	public void render() {		
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		//batch.setProjectionMatrix(camera.combined);
		//batch.begin();
		//sprite.draw(batch);
		//batch.end();
		
		figura1.setY(figura1.getY()+3);
		figura1.setX(figura1.getX()-1);
		figura1.setScale(figura1.getScaleX()-0.1f,figura1.getScaleY()+0.1f);
		

		if (figura2.getX()>300)
		{
			izquierda=true;
		}
		if(figura2.getX()<1)
		{
			izquierda = false;
		}

		if (izquierda==true)
		{
			figura2.setX(figura2.getX()-1);
		}
		else
		{
			figura2.setX(figura2.getX()+1);
		}	


		
	//image.setRotation(image.getRotation()-1);
	//image.setX(image.getX()+5);
		//if(image.getX()>700)
			//image.setX(-500);
		
			
		stage.draw();
	
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
}
