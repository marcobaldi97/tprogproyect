package uytube.admin.usuarios.listar;

import java.awt.Container;
import java.awt.ScrollPane;

import javax.swing.JInternalFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import uytubeLogic.logica.DtUsuario;

public final class ListarUsuariosInternalFrame {
	private final JInternalFrame internalFrame = new JInternalFrame();
	private final JPanel mainPanel = new JPanel();

	private final Container container;

	public ListarUsuariosInternalFrame(final Container container) {
		this.container = container;
		this.container.add(internalFrame);

		initializeInternalFrame();
	}

	private void initializeInternalFrame() {
		internalFrame.setVisible(false);
		internalFrame.setTitle("Alta Video");
		internalFrame.setClosable(true);
		internalFrame.setResizable(true);
		internalFrame.setSize(330, 300);

		initializeMainPanel();
		addContentToInternalFrame();
	}

	private void initializeMainPanel() {
		final JList<DtUsuario> userList = new JList<DtUsuario>(getUsers());

		final JScrollPane scrollPane = new JScrollPane(userList);

		mainPanel.add(scrollPane);
	}

	private DtUsuario[] getUsers() {
		final DtUsuario[] users = {};

		return users;
	}

	private void addContentToInternalFrame() {
		internalFrame.add(mainPanel);
	}

	public void show() {
		internalFrame.show();
	}

	public void hide() {
		internalFrame.hide();
	}
}
