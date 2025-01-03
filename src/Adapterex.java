public class Adapterex {


    public interface MediaPlayer {
        void play(String audioType, String fileName);
    }


    public interface AdvancedMediaPlayer {
        void playVlc(String fileName);
        void playMp4(String fileName);
    }


    public static class VlcPlayer implements AdvancedMediaPlayer {
        @Override
        public void playVlc(String fileName) {
            System.out.println("Playing vlc file. Name: " + fileName);
        }

        @Override
        public void playMp4(String fileName) {

        }
    }


    public static class Mp4Player implements AdvancedMediaPlayer {
        @Override
        public void playVlc(String fileName) {

        }

        @Override
        public void playMp4(String fileName) {
            System.out.println("Playing mp4 file. Name: " + fileName);
        }
    }


    public static class MediaAdapter implements MediaPlayer {
        AdvancedMediaPlayer advancedMusicPlayer;

        public MediaAdapter(String audioType) {
            if (audioType.equalsIgnoreCase("vlc")) {
                advancedMusicPlayer = new VlcPlayer();
            } else if (audioType.equalsIgnoreCase("mp4")) {
                advancedMusicPlayer = new Mp4Player();
            }
        }

        @Override
        public void play(String audioType, String fileName) {
            if (audioType.equalsIgnoreCase("vlc")) {
                advancedMusicPlayer.playVlc(fileName);
            } else if (audioType.equalsIgnoreCase("mp4")) {
                advancedMusicPlayer.playMp4(fileName);
            }
        }
    }


    public static class AudioPlayer implements MediaPlayer {
        MediaAdapter mediaAdapter;

        @Override
        public void play(String audioType, String fileName) {
            if (audioType.equalsIgnoreCase("mp3")) {
                System.out.println("Playing mp3 file. Name: " + fileName);
            } else if (audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")) {
                mediaAdapter = new MediaAdapter(audioType);
                mediaAdapter.play(audioType, fileName);
            } else {
                System.out.println("Invalid media. " + audioType + " format not supported");
            }
        }
    }


    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();

        audioPlayer.play("mp3", "beyond the horizon.mp3");
        audioPlayer.play("mp4", "alone.mp4");
        audioPlayer.play("vlc", "far far away.vlc");
        audioPlayer.play("avi", "mind me.avi");

    }
}
