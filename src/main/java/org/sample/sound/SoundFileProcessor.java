package org.sample.sound;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

import org.apache.commons.io.FileUtils;

public class SoundFileProcessor {

	private File inputFile = new File("C:\\Users\\muqtarahmed_baig\\Documents\\my\\quran\\094-ash-sharh_1.wav");
	//private ByteArrayOutputStream out;
	private AudioFormat format;
	private int frameSize;
	
	public File getAudioFile() throws IOException {
        byte[] audio = FileUtils.readFileToByteArray(inputFile); //out.toByteArray();
        InputStream input = new ByteArrayInputStream(audio);
        try {

            final AudioFormat format = getFormat();
            final AudioInputStream ais =
                    new AudioInputStream(input, format,
                            audio.length / format.getFrameSize());
            AudioSystem.write(ais, AudioFileFormat.Type.WAVE, new File("C:\\Users\\muqtarahmed_baig\\Documents\\my\\quran\\temp.wav"));
            input.close();
            System.out.println("New file created!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return new File("temp.wav");
    }
	
	private AudioFormat getFormat() throws IOException {
		
        File file = inputFile; //new File("src/Facebook/1.wav");
        System.out.println(inputFile);
       // byte[] out = FileUtils.readFileToByteArray(inputFile);
        AudioInputStream stream;
        try {
            stream = AudioSystem.getAudioInputStream(file);
            System.out.println("getformat ");
            format=stream.getFormat();
            System.out.println("format "+format);
            frameSize=stream.getFormat().getFrameSize();
            System.out.println("framesize "+frameSize);
            return stream.getFormat();
        } catch (UnsupportedAudioFileException e) {

        	e.printStackTrace();
        } catch (IOException e) {
        	e.printStackTrace();
        }
        return null;
    }

	
	public static void main(String[] args) throws IOException {
		SoundFileProcessor sfp = new SoundFileProcessor();
	//	sfp.getFormat();
		sfp.getAudioFile();
	}
}
