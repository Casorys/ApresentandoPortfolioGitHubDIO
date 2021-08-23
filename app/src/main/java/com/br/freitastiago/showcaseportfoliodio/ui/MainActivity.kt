package com.br.freitastiago.showcaseportfoliodio.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.SearchView
import com.br.freitastiago.showcaseportfoliodio.R
import com.br.freitastiago.showcaseportfoliodio.core.createDialog
import com.br.freitastiago.showcaseportfoliodio.core.createProgressDialog
import com.br.freitastiago.showcaseportfoliodio.core.hideSoftKeyboard
import com.br.freitastiago.showcaseportfoliodio.databinding.ActivityMainBinding
import com.br.freitastiago.showcaseportfoliodio.presentation.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() { // , SearchView.OnQueryTextListener

    private val dialog by lazy {createProgressDialog()}
    private val viewModel by viewModel<MainViewModel>()
    private val adapter by lazy { RepoListAdapter() }
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        binding.rvRepos.adapter = adapter

        viewModel.getRepoList("Casorys")

        viewModel.repos.observe(this) {
            when (it) {
                is MainViewModel.State.Error ->
                    createDialog {
                        setMessage(it.error.message)
                    }.show()
                MainViewModel.State.Loading -> dialog.show()
                is MainViewModel.State.Success -> {
                    dialog.dismiss()
                    adapter.submitList(it.list)
                }
            }
        }
    }

  //  override fun onCreateOptionsMenu(menu: Menu): Boolean {
   //     menuInflater.inflate(R.menu.main_menu, menu)
   //     val searchView = menu.findItem(R.id.action_search).actionView as SearchView
   //     searchView.setOnQueryTextListener(this)
    //    return super.onCreateOptionsMenu(menu)
   // }

  //  override fun onQueryTextSubmit(query: String?): Boolean {
   //     query?.let { viewModel.getRepoList(it) }
    //    binding.root.hideSoftKeyboard()
    //    return true
   // }

  //  override fun onQueryTextChange(newText: String?): Boolean {
  //      Log.e(TAG, "onQueryTextChange: $newText")
   //     return false
   // }

    companion object {
        private const val TAG = "TAG"
    }

}