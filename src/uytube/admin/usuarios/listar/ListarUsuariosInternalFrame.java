package uytube.admin.usuarios.listar;

import java.awt.Container;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;

public final class ListarUsuariosInternalFrame {
	private final JInternalFrame internalFrame = new JInternalFrame();
	private final JPanel listarUsuariosPanel = new JPanel();

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

		addContentToInternalFrame();
	}

	private void addContentToInternalFrame() {
		final JPanel listarUsuariosPanel = getListarUsuariosPanel();

		internalFrame.add(listarUsuariosPanel);
	}

	private JPanel getListarUsuariosPanel() {
		return listarUsuariosPanel;
	}

	public void show() {
		internalFrame.show();
	}

	public void hide() {
		internalFrame.hide();
	}
}
