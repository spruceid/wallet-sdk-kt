package com.spruceid.wallet.sdk

import android.util.Log
import com.spruceid.wallet.sdk.rs.MDoc as InnerMDoc

class MDoc(id: String, issuerAuth: ByteArray, val keyAlias: String) : BaseCredential(id) {
     val inner: InnerMDoc

    init {
        try {
            inner = InnerMDoc.fromCbor(issuerAuth)
        } catch (e: Throwable) {
            Log.e("MDoc.init", e.toString())
            throw e
        }
    }
}