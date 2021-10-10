
package Recognizer;

import Util.ConnectDB;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Array;
import javax.imageio.ImageIO;
import javax.swing.SwingWorker;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.DoublePointer;
import org.bytedeco.javacpp.IntPointer;
import static org.bytedeco.opencv.global.opencv_imgcodecs.imencode;
import org.bytedeco.opencv.global.opencv_imgproc;
import static org.bytedeco.opencv.global.opencv_imgproc.COLOR_BGRA2GRAY;
import static org.bytedeco.opencv.global.opencv_imgproc.cvtColor;
import static org.bytedeco.opencv.global.opencv_imgproc.rectangle;
import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.opencv_core.Rect;
import org.bytedeco.opencv.opencv_core.RectVector;
import org.bytedeco.opencv.opencv_core.Scalar;
import org.bytedeco.opencv.opencv_core.Size;
import org.bytedeco.opencv.opencv_face.FaceRecognizer;
import org.bytedeco.opencv.opencv_face.LBPHFaceRecognizer;

import org.bytedeco.opencv.opencv_objdetect.CascadeClassifier;
import org.bytedeco.opencv.opencv_videoio.VideoCapture;
import org.netbeans.lib.awtextra.AbsoluteLayout;

public class Recognizer extends javax.swing.JFrame {

	private Recognizer.DaemonThread myThread = null;

	// JavaCV
	VideoCapture webSource = null;
	Mat cameraImage = new Mat();
	CascadeClassifier cascade = new CascadeClassifier("C:\\photos\\haarcascade_frontalface_alt.xml");
	BytePointer mem = new BytePointer();
	RectVector detectedFaces = new RectVector();

	FaceRecognizer recognizer = LBPHFaceRecognizer.create();

	String root, firstNamePerson, lastNamePerson, officePerson, dobPerson;
	int idPerson;
	ConnectDB db = new ConnectDB();

	public Recognizer() {
		initComponents();

		recognizer.read("C:\\photos\\classifierLBPH.yml");

		recognizer.setThreshold(80);
		startCamera();
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		label_photo = new javax.swing.JLabel();
		jPanel2 = new javax.swing.JPanel();
		labelOffice = new javax.swing.JLabel();
		label_name = new javax.swing.JLabel();
		labelDob = new javax.swing.JLabel();
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("Security System - Recognizer Person");
		getContentPane().setLayout(new AbsoluteLayout());

		jPanel1.setBackground(new java.awt.Color(250, 250, 250));
		jPanel1.setLayout(new AbsoluteLayout());

		label_photo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 200, 200)));
		jPanel1.add(label_photo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 440, 450));

		jPanel2.setBackground(new java.awt.Color(255, 255, 255));
		jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		labelOffice.setBackground(new java.awt.Color(114, 138, 197));
		labelOffice.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
		labelOffice.setForeground(new java.awt.Color(255, 255, 255));
		labelOffice.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		labelOffice.setText("Office");
		labelOffice.setOpaque(true);
		jPanel2.add(labelOffice, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 420, 40));

		label_name.setBackground(new java.awt.Color(114, 138, 197));
		label_name.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
		label_name.setForeground(new java.awt.Color(255, 255, 255));
		label_name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		label_name.setText("First - Last Name");
		label_name.setOpaque(true);
		jPanel2.add(label_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 420, 40));

		labelDob.setBackground(new java.awt.Color(114, 138, 197));
		labelDob.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
		labelDob.setForeground(new java.awt.Color(255, 255, 255));
		labelDob.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		labelDob.setText("Dob");
		labelDob.setOpaque(true);
		jPanel2.add(labelDob, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 420, 40));

		jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 440, 170));

		getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 640));

		setSize(new java.awt.Dimension(498, 692));
		setLocationRelativeTo(null);
	}// </editor-fold>//GEN-END:initComponents

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
		// (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
		 * look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Windows".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Recognizer.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Recognizer.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Recognizer.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Recognizer.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Recognizer().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JLabel labelDob;
	private javax.swing.JLabel labelOffice;
	private javax.swing.JLabel label_name;
	private javax.swing.JLabel label_photo;
	// End of variables declaration//GEN-END:variables

	class DaemonThread implements Runnable {

		protected volatile boolean runnable = false;

		@Override
		public void run() {
			synchronized (this) {
				while (runnable) {
					try {
						if (webSource.grab()) {
							webSource.retrieve(cameraImage);
							Graphics g = label_photo.getGraphics();

							Mat imageGray = new Mat();
							cvtColor(cameraImage, imageGray, COLOR_BGRA2GRAY);

							RectVector detectedFace = new RectVector();
							cascade.detectMultiScale(imageGray, detectedFace, 1.1, 2, 0, new Size(150, 150),
									new Size(500, 500));

							for (int i = 0; i < detectedFace.size(); i++) {
								Rect dadosFace = detectedFace.get(i);
								rectangle(cameraImage, dadosFace, new Scalar(0, 255, 0, 0));
								Mat faceCapturada = new Mat(imageGray, dadosFace);
								opencv_imgproc.resize(faceCapturada, faceCapturada, new Size(160, 160));

								IntPointer rotulo = new IntPointer(1);
								DoublePointer confidence = new DoublePointer(1);
								recognizer.predict(faceCapturada, rotulo, confidence);
								int prediction = rotulo.get(0);

								if (prediction == -1) {
									idPerson = 0;
									label_name.setText("");
									labelDob.setText("");
									labelOffice.setText("");

								} else {
									System.out.println(confidence.get(0));
									idPerson = prediction;
									rec();
								}
								// int x = Math.max(dadosFace.tl().x() - 10, 0);
								// int y = Math.max(dadosFace.tl().y() - 10, 0);
								// putText(imagemCamera, nome, new Point(x, y), FONT_HERSHEY_PLAIN, 1.7, new
								// Scalar(0, 255, 0, 2));
							}

							imencode(".bmp", cameraImage, mem);
							Image im = ImageIO.read(new ByteArrayInputStream(mem.getStringBytes()));
							BufferedImage buff = (BufferedImage) im;

							if (g.drawImage(buff, 0, 0, getWidth(), getHeight() - 100, 0, 0, buff.getWidth(),
									buff.getHeight(), null)) {
								if (runnable == false) {
									System.out.println("Save photo");
									this.wait();
								}
							}
						}
					} catch (IOException | InterruptedException ex) {
					}
				}
			}
		}

	}

	private void rec() {
		// Recognizer face with database
		SwingWorker worker = new SwingWorker() {
			@Override
			protected Object doInBackground() throws Exception {
				db.connect();
				try {
					String SQL = "SELECT * FROM person WHERE id = " + idPerson;
					db.executeSQL(SQL);
					while (db.rs.next()) {
						label_name.setText(db.rs.getString("first_name") + " " + db.rs.getString("last_name"));
						labelDob.setText(db.rs.getString("dob"));
						labelOffice.setText(db.rs.getString("office"));
						System.out.println("Perosn ID: " + db.rs.getString("id"));

						Array ident = db.rs.getArray("first_name");
						String[] person = (String[]) ident.getArray();
						for (int i = 0; i < person.length; i++) {
							System.out.println(person[i]);
						}
					}
				} catch (Exception e) {
				}
				db.disconnect();
				return null;
			}
		};
		worker.execute();
	}

	public void stopCamera() {
		myThread.runnable = false;
		webSource.release();
		dispose();
	}

	public void startCamera() {
		webSource = new VideoCapture(0);
		myThread = new Recognizer.DaemonThread();
		Thread t = new Thread(myThread);
		t.setDaemon(true);
		myThread.runnable = true;
		t.start();
	}
}
