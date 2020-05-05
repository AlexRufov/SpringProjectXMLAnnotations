package ru.alexrufov.SpringProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;

@Component
public class MusicPlayer {

    @Value("${musicPlayer.playerName}")
    private String name;
    @Value("${musicPlayer.volume}")
    private int volume;

    public String getName() {
        return name;
    }

    public int getVolume() {
        return volume;
    }

    private Music music1;
    private Music music2;

    @Autowired
    public MusicPlayer(@Qualifier("classicalMusic") Music music1, @Qualifier("rockMusic") Music music2) {
        this.music1 = music1;
        this.music2 = music2;
    }

    @PostConstruct
    public void doMyInit(){
        System.out.println("Start playing");
    }
    @PreDestroy
    public void doMyDestroy(){
        System.out.println("End playing");
    }

    public String playMusic(){
        return "Playing: " + music1.getSong() + " >> " + music2.getSong();
    }
}
