package com.openstreet.www.maps_bmsit


import android.content.pm.PackageManager
import android.graphics.Color
import android.location.Location
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.chaquo.python.PyObject
import com.chaquo.python.Python
import com.chaquo.python.android.AndroidPlatform
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolylineOptions
import kotlinx.android.synthetic.main.activity_maps.*

class MapsActivity : AppCompatActivity(), OnMapReadyCallback, GoogleMap.OnMarkerClickListener {
    private lateinit var mMap: GoogleMap
    private lateinit var lastLocation: Location
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

    }
    override fun onMarkerClick(p0: Marker?) = false
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        mMap.uiSettings.isZoomControlsEnabled = true
        mMap.setOnMarkerClickListener(this)
        setUpMap()

    }
    companion object {
        private const val LOCATION_PERMISSION_REQUEST_CODE = 1
    }
    private fun placeMarkerOnMap(location: LatLng) {

        val markerOptions = MarkerOptions().position(location)

        mMap.addMarker(markerOptions)
    }

    //Permission
    private fun setUpMap() {
        if (ActivityCompat.checkSelfPermission(this,android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), LOCATION_PERMISSION_REQUEST_CODE)

            return
        }
        mMap.isMyLocationEnabled=true
        fusedLocationClient.lastLocation.addOnSuccessListener(this) { location ->
            if (location != null) {
                    lastLocation = location
                    var currentLatLng = LatLng(location.latitude, location.longitude)
                    placeMarkerOnMap(currentLatLng)
                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLatLng, 12f))
                    search.setOnClickListener {
                        val text=info_text2.text.toString()
                        if(Python.isStarted()){
                            Python.start( AndroidPlatform(this))
                        }
                        val py:Python=Python.getInstance()
                        val pyf:PyObject=py.getModule("code.py")
                        val obj:PyObject=pyf.callAttr("dijkstra",currentLatLng,text)
                        for(item in obj.keys) {
                            if (item== "Bmsit0") {
                                val bmsit = LatLng(13.134334, 77.56793)
                                mMap.addMarker(MarkerOptions().position(bmsit).title("Marker in BMSIT GATE"))
                                mMap.moveCamera(CameraUpdateFactory.newLatLng(bmsit))
                                mMap.addPolyline(
                                        PolylineOptions()
                                                .add(currentLatLng)
                                                .add(bmsit)
                                                .width(8f)
                                                .color(Color.CYAN)
                                )
                                currentLatLng = bmsit
                            } else if (text == "Bmsit1") {
                                val bmsit = LatLng(13.134955, 77.567012)
                                mMap.addMarker(MarkerOptions().position(bmsit).title("Marker in BMSIT GATE"))
                                mMap.moveCamera(CameraUpdateFactory.newLatLng(bmsit))
                                mMap.addPolyline(
                                        PolylineOptions()
                                                .add(currentLatLng)
                                                .add(bmsit)
                                                .width(8f)
                                                .color(Color.CYAN)
                                )
                                currentLatLng = bmsit
                            } else if (text == "Bmsit2") {
                                val bmsit = LatLng(13.133979, 77.566916)
                                mMap.addMarker(MarkerOptions().position(bmsit).title("Marker in BMSIT GATE"))
                                mMap.moveCamera(CameraUpdateFactory.newLatLng(bmsit))
                                mMap.addPolyline(
                                        PolylineOptions()
                                                .add(currentLatLng)
                                                .add(bmsit)
                                                .width(8f)
                                                .color(Color.CYAN)
                                )
                                currentLatLng = bmsit
                            } else if (text == "Bmsit3") {
                                val bmsit = LatLng(13.134455, 77.569096)
                                mMap.addMarker(MarkerOptions().position(bmsit).title("Marker in BMSIT GATE"))
                                mMap.moveCamera(CameraUpdateFactory.newLatLng(bmsit))
                                mMap.addPolyline(
                                        PolylineOptions()
                                                .add(currentLatLng)
                                                .add(bmsit)
                                                .width(8f)
                                                .color(Color.CYAN)
                                )
                                currentLatLng = bmsit
                            } else if (text == "Bmsit4") {
                                val bmsit = LatLng(13.133974, 77.56911)
                                mMap.addMarker(MarkerOptions().position(bmsit).title("Marker in BMSIT GATE"))
                                mMap.moveCamera(CameraUpdateFactory.newLatLng(bmsit))
                                mMap.addPolyline(
                                        PolylineOptions()
                                                .add(currentLatLng)
                                                .add(bmsit)
                                                .width(8f)
                                                .color(Color.CYAN)
                                )
                                currentLatLng = bmsit
                            } else if (text == "Bmsit5") {
                                val bmsit = LatLng(13.1341, 77.569487)
                                mMap.addMarker(MarkerOptions().position(bmsit).title("Marker in BMSIT GATE"))
                                mMap.moveCamera(CameraUpdateFactory.newLatLng(bmsit))
                                mMap.addPolyline(
                                        PolylineOptions()
                                                .add(currentLatLng)
                                                .add(bmsit)
                                                .width(8f)
                                                .color(Color.CYAN)
                                )
                                currentLatLng = bmsit
                            } else if (text == "Bmsit6") {
                                val bmsit = LatLng(13.133819, 77.568689)
                                mMap.addMarker(MarkerOptions().position(bmsit).title("Marker in BMSIT GATE"))
                                mMap.moveCamera(CameraUpdateFactory.newLatLng(bmsit))
                                mMap.addPolyline(
                                        PolylineOptions()
                                                .add(currentLatLng)
                                                .add(bmsit)
                                                .width(8f)
                                                .color(Color.CYAN)
                                )
                                currentLatLng = bmsit
                            } else if (text == "Bmsit Gate7") {
                                val bmsit = LatLng(13.133947, 77.567498)
                                mMap.addMarker(MarkerOptions().position(bmsit).title("Marker in BMSIT GATE"))
                                mMap.moveCamera(CameraUpdateFactory.newLatLng(bmsit))
                                mMap.addPolyline(
                                        PolylineOptions()
                                                .add(currentLatLng)
                                                .add(bmsit)
                                                .width(8f)
                                                .color(Color.CYAN)
                                )
                                currentLatLng = bmsit
                            } else if (text == "Bmsit8") {
                                val bmsit = LatLng(13.133311, 77.567559)
                                mMap.addMarker(MarkerOptions().position(bmsit).title("Marker in BMSIT GATE"))
                                mMap.moveCamera(CameraUpdateFactory.newLatLng(bmsit))
                                mMap.addPolyline(
                                        PolylineOptions()
                                                .add(currentLatLng)
                                                .add(bmsit)
                                                .width(8f)
                                                .color(Color.CYAN)
                                )
                                currentLatLng = bmsit
                            } else if (text == "Bmsit9") {
                                val bmsit = LatLng(13.133409, 77.568647)
                                mMap.addMarker(MarkerOptions().position(bmsit).title("Marker in BMSIT GATE"))
                                mMap.moveCamera(CameraUpdateFactory.newLatLng(bmsit))
                                mMap.addPolyline(
                                        PolylineOptions()
                                                .add(currentLatLng)
                                                .add(bmsit)
                                                .width(8f)
                                                .color(Color.CYAN)
                                )
                                currentLatLng = bmsit
                            } else if (text == "Bmsit10") {
                                val bmsit = LatLng(13.132761, 77.568677)
                                mMap.addMarker(MarkerOptions().position(bmsit).title("Marker in BMSIT GATE"))
                                mMap.moveCamera(CameraUpdateFactory.newLatLng(bmsit))
                                mMap.addPolyline(
                                        PolylineOptions()
                                                .add(currentLatLng)
                                                .add(bmsit)
                                                .width(8f)
                                                .color(Color.CYAN)
                                )
                                currentLatLng = bmsit
                            }
                        }
                        }

                }

            }
        }
    }


