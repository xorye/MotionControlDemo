package sprites;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

/**
 * Created by david on 7/6/2016.
 */
public class Animation {
    private Array<TextureRegion> frames;
    //max time the cat stays in one frame
    private float maxFrameTime;
    //the time the cat stayed on the current frame
    private float currentFrameTime;
    //number of frames in the animation (4)
    private int frameCount;
    //total frames in image (8)
    private int totalFrames;
    //the index of the current frame in the array
    private int frame;

    public Animation(TextureRegion region, int frameCount, int totalFrames, int direction, float cycleTime){
        frames = new Array<TextureRegion>();

        //declare the width of the frame so that we know where to cut the TextureRegions for each frame
        int frameWidth = region.getRegionWidth()/totalFrames;

        for(int i = 0; i < totalFrames; i++){
            frames.add(new TextureRegion(region,i*frameWidth, 0, frameWidth, region.getRegionHeight()));
        }
        this.frameCount = frameCount;
        this.totalFrames = totalFrames;
        maxFrameTime = cycleTime/frameCount;
        if(direction == 1 || direction == 0) {
            frame = 0;
        }else{
            frame = 4;

        }
    }

    //update method to change frames
    public void update(float dt, int direction){
        currentFrameTime += dt;

        System.out.println(frame);

        if(direction == 1){

            if(currentFrameTime >= maxFrameTime){
                frame++;
                currentFrameTime = 0;
            }

            if(frame >= frameCount){
                frame = 0;
            }
        }else if(direction == 2){
            System.out.println("currentFrameTime: "+currentFrameTime);
            System.out.println("currentFrame: "+frame);

            if(currentFrameTime >= maxFrameTime){
                frame++;
                currentFrameTime = 0;
            }

            if(frame == totalFrames || frame<5){
                frame = 4;
            }
        }




    }

    public TextureRegion getFrame(){
        return frames.get(frame);
    }
}
