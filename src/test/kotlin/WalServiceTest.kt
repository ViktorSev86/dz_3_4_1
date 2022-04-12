import org.junit.Assert.*
import org.junit.Test

class WalServiceTest {

    @Test
    fun createMessage() {
        val service = WalService
        service.createMessage(1, 2, "Привет. Как дела?")
    }

    @Test
    fun editMessageTrue() {
        val service = WalService
        service.createMessage(1, 2, "Привет. Как дела?")
        service.createMessage(2, 1, "Привет. Как дела?")
        assertTrue(service.editMessage(1, Message(2, 2, 1, false, "Другое сообщение")))
    }

    @Test
    fun editMessageFalseChat() {
        val service = WalService
        service.createMessage(1, 2, "Привет. Как дела?")
        assertFalse(service.editMessage(100, Message(1, 1, 2, false, "Другое сообщение")))
    }

    @Test
    fun editMessageFalse() {
        val service = WalService
        service.createMessage(1, 2, "Привет. Как дела?")
        assertFalse(service.editMessage(1, Message(100, 1, 2, false, "Другое сообщение")))
    }

    @Test
    fun deleteMessage() {
        val service = WalService
        service.createMessage(1, 2, "Привет. Как дела?")
        assertTrue(service.deleteMessage(1, 1))
    }

    @Test
    fun deleteMessageTrue() {
        val service = WalService
        service.createMessage(1, 2, "Привет. Как дела?")
        service.createMessage(2, 1, "Нормально.")
        assertTrue(service.deleteMessage(1, 1))
    }

    @Test
    fun deleteMessageFalseChat() {
        val service = WalService
        service.createMessage(1, 2, "Привет. Как дела?")
        service.createMessage(2, 1, "Нормально.")
        assertFalse(service.deleteMessage(100, 1))
    }

    @Test
    fun deleteMessageFalse() {
        val service = WalService
        service.createMessage(1, 2, "Привет. Как дела?")
        service.createMessage(2, 1, "Нормально.")
        assertFalse(service.deleteMessage(1, 100))
    }

    @Test
    fun getAllChatsUser() {
        val service = WalService
        service.createMessage(1, 2, "Привет. Как дела?")
        service.createMessage(2, 1, "Нормально.")
        service.getAllChatsUser(1)
    }

    @Test
    fun getUnreadChatsCountTrue() {
        val service = WalService
        service.createMessage(1, 2, "Привет. Как дела?")
        service.createMessage(2, 1, "Нормально.")
        service.createMessage(3, 1, "Привет. Как дела?")
        service.createMessage(4, 1, "Нормально.")
        val n: Int = service.getUnreadChatsCount(1)
        assertTrue(n == 3)
    }

    @Test
    fun getUnreadChatsCountFalse() {
        val service = WalService
        service.createMessage(1, 2, "Привет. Как дела?")
        service.createMessage(2, 1, "Нормально.")
        service.createMessage(3, 1, "Привет. Как дела?")
        service.createMessage(4, 1, "Нормально.")
        val n: Int = service.getUnreadChatsCount(1)
        assertFalse(n == 100)
    }

    @Test
    fun getMessages() {
        val service = WalService
        service.createMessage(1, 2, "Привет. Как дела?")
        service.createMessage(2, 1, "Нормально.")
        service.createMessage(1, 2, "Привет. Как дела?")
        service.createMessage(2, 1, "Нормально.")
        service.getMessages()
    }

    @Test
    fun getMessagesUser() {
        val service = WalService
        service.createMessage(1, 2, "Привет. Как дела?")
        service.createMessage(2, 1, "Нормально.")
        service.createMessage(1, 2, "Привет. Как дела?")
        service.createMessage(2, 1, "Нормально.")
        service.getMessagesUser(1)
    }

    @Test
    fun getLastMessages() {
        val service = WalService
        service.createMessage(1, 2, "Привет. Как дела?")
        service.createMessage(2, 1, "Нормально.")
        service.createMessage(1, 2, "Привет. Как дела?")
        service.createMessage(2, 1, "Нормально.")
        service.getLastMessages(1, 2, 1)
    }

    @Test
    fun getLastMessagesEmpty() {
        val service = WalService
        service.createMessage(1, 2, "Привет. Как дела?")
        service.createMessage(2, 1, "Нормально.")
        service.createMessage(1, 2, "Привет. Как дела?")
        service.createMessage(2, 1, "Нормально.")
        val p = service.getLastMessages(3, 5, 5)
        assertTrue(p.isEmpty())
    }

    @Test
    fun deleteChatTrue() {
        val service = WalService
        service.createMessage(1, 2, "Привет. Как дела?")
        service.createMessage(2, 1, "Нормально.")
        service.createMessage(1, 2, "Привет. Как дела?")
        service.createMessage(2, 1, "Нормально.")
        assertTrue(service.deleteChat(1))
    }

    @Test
    fun deleteChatFalse() {
        val service = WalService
        service.createMessage(1, 2, "Привет. Как дела?")
        service.createMessage(2, 1, "Нормально.")
        assertFalse(service.deleteChat(100))
    }
}