package sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.MotionDemo;
import com.sun.org.apache.xpath.internal.operations.String;

/**
 * Created by david on 7/6/2016.
 */
public class Cat {

    //the cats speed
    private static final int CAT_MOVEMENT = 80;

    //the cats position
    private Vector3 position;
    private Vector3 velocity;

    private Animation catAnimation;
    private Texture catTexture;


    //The starting position for the cat
    public Cat(int x, int y, int direction){
        position = new Vector3(x, y, 0);
        //cat is not moving at the start
        velocity = new Vector3(0,0,0);
        catTexture = new Texture("catanimation.png");
        //texture region number of frames, time per each frame
        catAnimation = new Animation(new TextureRegion(catTexture), 4, 8, direction, 0.5f);
    }
    public void update(float dt, int direction){
        catAnimation.update(dt, direction);

        if(direction == 1){
            position.add(CAT_MOVEMENT*dt, 0, 0);
        }else if(direction == 2){
            position.add(-(CAT_MOVEMENT*dt), 0, 0);
        }
        if(position.x >= MotionDemo.WIDTH/3-catAnimation.getFrame().getRegionWidth()){
            position.x = MotionDemo.WIDTH/3-catAnimation.getFrame().getRegionWidth();
        }
        if(position.x <= 0){
            position.x = 0;
        }

    }

    public TextureRegion getCat(){
        return catAnimation.getFrame();
    }
    public Vector3 getPosition(){
        return position;
    }
    public void dispose(){
        catTexture.dispose();
    }


}
