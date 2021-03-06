package ru.alexrufov.SpringProject;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class RockMusic implements Music {
    private RockMusic(){}

    public static RockMusic getRockMusic(){
        return new RockMusic();
    }
    @Override
    public String getSong() {
        return "Unforgiven";
    }
}
