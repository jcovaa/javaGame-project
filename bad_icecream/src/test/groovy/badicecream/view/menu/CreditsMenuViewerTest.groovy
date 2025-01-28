package badicecream.view.menu

import badicecream.gui.Gui
import badicecream.model.menu.CreditsMenu
import spock.lang.Specification

class CreditsMenuViewerTest extends Specification {

    def "test draw elements start selected"() {
        given: "mocked credits menu and gui and the credits menu viewer"
        def creditsMenu = Mock(CreditsMenu)
        def gui = Mock(Gui)
        def viewer = new CreditsMenuViewer(creditsMenu)

        when: "credits menu is drawn"
        creditsMenu.getWaterMelonsCollected() >> 5
        creditsMenu.getBananasCollected() >> 3
        creditsMenu.getGameStatus() >> "Game Over"
        creditsMenu.getEntry(0) >> "Restart"
        creditsMenu.getEntry(1) >> "Quit"
        creditsMenu.isSelected(0) >> true
        creditsMenu.isSelected(1) >> false

        viewer.drawElements(gui)

        then:
        1 * gui.drawText(3, 3, "Game Over", "#FF0000")
        1 * gui.drawText(0, 6, "Watermelons: 5", "#00FF00")
        1 * gui.drawText(0, 7, "Bananas: 3", "#FFFF00")
        1 * gui.drawText(1, 10, "Restart", "#FFD700")
        1 * gui.drawText(1, 12, "Quit", "#FFFFFF")
    }

    def "test draw elements exit selected"() {
        given: "mocked credits menu and gui and the credits menu viewer"
        def creditsMenu = Mock(CreditsMenu)
        def gui = Mock(Gui)
        def viewer = new CreditsMenuViewer(creditsMenu)

        when: "credits menu is drawn"
        creditsMenu.getWaterMelonsCollected() >> 5
        creditsMenu.getBananasCollected() >> 3
        creditsMenu.getGameStatus() >> "You win!"
        creditsMenu.getEntry(0) >> "Restart"
        creditsMenu.getEntry(1) >> "Quit"
        creditsMenu.isSelected(0) >> false
        creditsMenu.isSelected(1) >> true

        viewer.drawElements(gui)

        then:
        1 * gui.drawText(3, 3, "You win!", "#FF0000")
        1 * gui.drawText(0, 6, "Watermelons: 5", "#00FF00")
        1 * gui.drawText(0, 7, "Bananas: 3", "#FFFF00")
        1 * gui.drawText(1, 10, "Restart", "#FFFFFF")
        1 * gui.drawText(1, 12, "Quit", "#FFD700")
    }
}
