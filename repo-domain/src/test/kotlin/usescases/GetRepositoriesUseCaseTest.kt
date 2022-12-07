package usescases

import com.kenny.repo.domain.repositories.RepoRepositoryImpl
import com.kenny.repo.domain.usescases.GetRepositoriesUseCase
import com.kenny.repo.entities.entities.data.Repository
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.mockk
import io.reactivex.rxjava3.core.Single
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class GetRepositoriesUseCaseTest {

    @MockK
    private lateinit var repository: RepoRepositoryImpl

    private  lateinit var subject: GetRepositoriesUseCase

    @BeforeEach
    fun setUp() {
        subject = GetRepositoriesUseCase(repository)
    }

    @Test
    fun `Should return the list of repositories when getRepositories method is invoked`() {
        // given
        val query = "kotlin"
        val listRepositories =
            listOf(mockk<Repository>(), mockk<Repository>(), mockk<Repository>())

        every {
            repository.getRepositories(query)
        } returns Single.just(listRepositories)

        // when
        val testObserver = subject.execute(query).test()

        // then
        testObserver.assertResult(listRepositories)
        testObserver.assertNoErrors()
        testObserver.assertComplete()
    }

}