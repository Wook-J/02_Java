package edu.kh.io.pack2.run;

import edu.kh.io.pack2.model.service.ByteService;

public class Run {

	public static void main(String[] args) {
		
		ByteService bs = new ByteService();
//		bs.fileByteOutput();
//		bs.bufferedFileByteOutput();
//		bs.fileByteInput();
//		bs.fileByteInput2();
//		bs.bufferedFileByteInput();
		bs.fileCopy();
	}

}
