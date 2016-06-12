package com.donkeykong.game.Worlds;

import java.util.ArrayList;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.donkeykong.game.Entities.Entity;

public class World implements InputProcessor	
{
	ArrayList<Entity> entities = new ArrayList<Entity>();
	ShapeRenderer shapeRenderer;
	OrthographicCamera camera;
	
	public World(OrthographicCamera camera)
	{
		this.camera = camera;
		shapeRenderer = new ShapeRenderer();
		shapeRenderer.setProjectionMatrix(camera.combined);
		shapeRenderer.setAutoShapeType(true);
	}
	
	public void update(float dt)
	{
		for(Entity e : entities)
		{
			if(e != null)
				e.update(dt);
		}
	}
	
	public void draw(Batch batch)
	{
		batch.begin();
		for(Entity e : entities)
		{
			if(e != null)
				e.draw();
		}
		batch.end();
	}
	
	public void drawHitbox()
	{
		shapeRenderer.begin();
		for(Entity e : entities)
		{
			if(e != null)
				e.drawHitbox(shapeRenderer);
		}
		shapeRenderer.end();
	}
	
	public Entity addEntity(Entity e)
	{
		entities.add(e);
		return e;
	}
	
	public Entity removeEntity(Entity e)
	{
		entities.remove(e);
		return e;
	}

	@Override
	public boolean keyDown(int keycode)
	{
		for(Entity e : entities)
		{
			if(e != null)
				e.keyDown(keycode);
		}
		return false;
	}

	@Override
	public boolean keyUp(int keycode)
	{
		for(Entity e : entities)
		{
			if(e != null)
				e.keyUp(keycode);
		}
		return false;
	}

	@Override
	public boolean keyTyped(char character){return false;}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button){return false;}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button){return false;}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer){return false;}

	@Override
	public boolean mouseMoved(int screenX, int screenY){return false;}

	@Override
	public boolean scrolled(int amount){return false;}
}
