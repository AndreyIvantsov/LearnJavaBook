package ch12.mini_music_player_3;
import javax.swing.*;
import javax.sound.midi.*;

public class MiniMusicPlayer3 {
    
    static JFrame frame = new JFrame("Мой первый музыкальный клип");
    static MyDrawPanel panel;

    public static void main(String[] args) {
        MiniMusicPlayer3 mini = new MiniMusicPlayer3();
        mini.go();
    }

    public void setUpGui() {
        final int X_COORD = 30;
        final int Y_COORD = 30;
        final int HEIGHT = 300;
        final int WIDTH = 300;
        panel = new MyDrawPanel();
        frame.setContentPane(panel);
        frame.setBounds(X_COORD, Y_COORD, HEIGHT, WIDTH);
        frame.setVisible(true);
    }

    public void go() {
        final int EVENT_NUMBER = 127;
        final int RESOLUTION = 4;
        final int MIN_DATA_1 = 1;
        final int MAX_DATA_1 = 51;
        final int CHANAL = 1;
        final int COMMAND_1 = 144;
        final int COMMAND_2 = 176;
        final int COMMAND_3 = 128;
        final int DATA2 = 100;
        final float BMP = 120f;

        setUpGui();

        try {
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequencer.addControllerEventListener(panel, new int [] {EVENT_NUMBER});
            Sequence sequence = new Sequence(Sequence.PPQ, RESOLUTION);
            Track track = sequence.createTrack();

            for (int i = 0; i < 60; i += 4) {
                int data1 = Rand.rnd(MIN_DATA_1, MAX_DATA_1);
                track.add(makeEvent(COMMAND_1, CHANAL, data1, DATA2, i));
                track.add(makeEvent(COMMAND_2, CHANAL, EVENT_NUMBER, 0, i));
                track.add(makeEvent(COMMAND_3, CHANAL, data1, DATA2, i + 2));
            }

            sequencer.setSequence(sequence);
            sequencer.start();
            sequencer.setTempoInBPM(BMP);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public MidiEvent makeEvent (int command, int channel, int data1, int data2, int tick) {
        MidiEvent event = null;
        try {
            ShortMessage shortMessage = new ShortMessage();
            shortMessage.setMessage(command, channel, data1, data2);
            event = new MidiEvent(shortMessage, tick);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return event;
    }
}

