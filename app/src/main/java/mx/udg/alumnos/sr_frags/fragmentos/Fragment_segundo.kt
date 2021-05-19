package mx.udg.alumnos.sr_frags.fragmentos

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText
import mx.udg.alumnos.sr_frags.R
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val DEFAULT_URL = "urlPorDefault"

/**
 * A simple [Fragment] subclass.
 * Use the [Fragment_segundo.newInstance] factory method to
 * create an instance of this fragment.
 */
class Fragment_segundo : Fragment() {
    // TODO: Rename and change types of parameters

    private var url: String? = null
    lateinit var wvNavegador:WebView
    lateinit var btnIr:Button
    lateinit var etURL:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            url = it.getString(DEFAULT_URL)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("url:", url!!)
        // Inflate the layout for this fragment

        val VistaNavegador = inflater.inflate(R.layout.fragment_segundo, container, false)

        wvNavegador = VistaNavegador.findViewById(R.id.wvNavegador)
        btnIr = VistaNavegador.findViewById(R.id.btnIr)
        etURL = VistaNavegador.findViewById(R.id.etURL)

        val webSettings = wvNavegador.settings
        webSettings.javaScriptEnabled = true
        wvNavegador.webViewClient = object : WebViewClient(){}

        wvNavegador.loadUrl("www.$url")

        btnIr.setOnClickListener{
            url = etURL.text.toString().trim()
            if (!url!!.isEmpty()){
                url = "https://"+url
                wvNavegador.loadUrl(url!!)
            }
        }

        return VistaNavegador
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param url por default.
         * @return A new instance of fragment Fragment_segundo.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(urlPorDefault: String) =
            Fragment_segundo().apply {
                arguments = Bundle().apply {
                    putString(DEFAULT_URL, urlPorDefault)
                }
            }
    }
}