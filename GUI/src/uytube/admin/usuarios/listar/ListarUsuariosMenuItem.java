package uytube.admin.usuarios.listar;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

public final class ListarUsuariosMenuItem {
	private final JMenuItem menuItem = new JMenuItem("Listar Usuarios...");
	private final ListarUsuariosInternalFrame listarUsuariosInternalFrame;

	private final Container container;

	public ListarUsuariosMenuItem(final Container container) {
		this.container = container;
		this.listarUsuariosInternalFrame = new ListarUsuariosInternalFrame(this.container);

		initializeMenuItem();
	}

	public JMenuItem getMenuItem() {
		return menuItem;
	}

	private void initializeMenuItem() {
		addClickEventHandlerToMenuItem();
	}

	private void addClickEventHandlerToMenuItem() {
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showAltaVideoInternalFrame();
			}
		});
	}

	private void showAltaVideoInternalFrame() {
		listarUsuariosInternalFrame.show();
	}
}
