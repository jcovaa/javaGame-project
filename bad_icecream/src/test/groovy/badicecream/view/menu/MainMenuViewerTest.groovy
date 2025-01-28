package badicecream.view.menu

import badicecream.gui.Gui
import badicecream.model.menu.MainMenu
import spock.lang.Specification

class MainMenuViewerTest extends Specification{

    def "test draw elements start selected"() {
        given: "mocked main menu and gui and the main menu viewer"
        def mainMenu = Mock(MainMenu)
        def gui = Mock(Gui)
        def viewer = new MainMenuViewer(mainMenu)

        when: "main menu is drawn"
        mainMenu.getEntry(0) >> "Start"
        mainMenu.getEntry(1) >> "Quit"
        mainMenu.isSelected(0) >> true
        mainMenu.isSelected(1) >> false

        viewer.drawElements(gui)

        then:
        1 * gui.drawText(1, 3, "Bad Ice-Cream", "#00FFFF")
        1 * gui.drawText(1, 7, "Start", "#FFD700")
        1 * gui.drawText(1, 9, "Quit", "#FFFFFF")
    }

    def "test draw elements exit selected"() {
        given: "mocked main menu and gui and the main menu viewer"
        def mainMenu = Mock(MainMenu)
        def gui = Mock(Gui)
        def viewer = new MainMenuViewer(mainMenu)

        when: "main menu is drawn"
        mainMenu.getEntry(0) >> "Start"
        mainMenu.getEntry(1) >> "Quit"
        mainMenu.isSelected(0) >> false
        mainMenu.isSelected(1) >> true

        viewer.drawElements(gui)

        then:
        1 * gui.drawText(1, 3, "Bad Ice-Cream", "#00FFFF")
        1 * gui.drawText(1, 7, "Start", "#FFFFFF")
        1 * gui.drawText(1, 9, "Quit", "#FFD700")
    }
}
