package com.example.okhttpvolleygson.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.okhttpvolleygson.adapters.NetworkImageRecyclerViewAdapter;
import com.sottocorp.okhttpvolleygson.R;

import java.util.Arrays;
import java.util.List;

public class NetworkImageViewActivity extends AppCompatActivity
{
    private final static List<String> sImages = Arrays.asList
    (
        "https://lh3.googleusercontent.com/R_GU7QfC0yYHkoWwbciKeMEPnxzIIz9QCRzmqM2RKOOuyy9N3flc5nue4MOsJz3C8CIHjxAwuHEMIsf3_G9rekyVb-mLvNvjD3GvkbYfVew6OaCXTh45Nkcq7066GIKH1GVN2RTwepFBrkxUsT_2_gfySz9y-ofMkUOo66tI_c09b-esvF1R0YWGWQMhd6arQkvtd8BuEJECEeIze0xGbUm9ntwGOt63muGfMEB68a557f2eGuTK5yBTHRXhB9sQodJDf3H_Igb8G7quTx-OakgIMCdtah9P7FiR5qH_dQaHIBfl7QDv5UWoFvuRFM_BuTIiMMu5pCn_3aS6axTiDQoK-5INjnf4ZQRQeaPJFWYlb6LJcg7DrPXB5Vb_XwKiMWKIsrxryO4wDV0z9XCTj94glyfZtUq7zZFxUOw78l2TKqs_968IZAkI-krKBzMy04r8H2u4h0LNMRxIKsdOEzADwphkwquSd63DGgi1SxEsinwIfCVkBGshpDGk3vhqAS-EIL96TNn8lCMk7h4V-qlw3lCBSVb2f44ptUq99b-I5BuA9yLJ8w1Uk2VcpreHqsArqNs0GvcODIAY4G0QhKyljbuUC5l7=w1270-h953-no",
        "https://lh3.googleusercontent.com/z1U_YDTeJBvbokesY4-9tVHBlQkr1oFZjEs9pQYZ2V9q22wcwN69ZCp-WJSLZXve_-8cLBYjOn1s9SF9x_LG3m4sWPAMaH-3Lpm3m4SDjLIwelwgElaw6K--5ZEbYtcNF7QWZnzKiAKdByen8w0bus6DmSFq8CzMCtLgWIyuxJq783uiloQlNm9HdC_Pi0JmmzXeZLokijTVdy1QjMr8xrsxOj1OxyBWoPwyx_M6MxJKG1JWMwL1EsfM_4pRPZfbG1sExPsnjdQZzLpTq6y5y1RBjy2xCrXWitncqQnj7ePU0IQyPBiCgUSHD_ltA9aNCwlvGGUA535_RQ7s3ZSv0IdaWP8WJJE2cafz5lzhem19JZFGZFKkmIEAwFRHPOqZwuPIMWfveeprDRbEbPwzlsVvXoEOIkGGKQvZiBABvzlNMWo4-0_1J94OmhGYMckBp1ncbsitEhi3wcEitBTtwG_4EgmW5pKy53TfxgwSu4jZ7MdSQCbMcr_S9CnzEMLi6G67TGTNlOutIx-WKnItuh1fxDiD4XweFgRyXoWfEc50Zrpg8YIYPJ0sXjGWpS7ZUNV-r_vs1YFS66S2Kcq_p4VYelAgeX3a=w1270-h953-no",
        "https://lh3.googleusercontent.com/VGr56pJFb7hCeQwsL9hfMN8jYiXuS8JOUZJSuZk7YlP5S4Hv2c187i_y_V_kDDR6-EFvVApoqJ2er5T-Leys8LUR29oPVGiihgDGaXcEYKztzao3DeKwdhJ0CidgOCtXLnbbyffxcVtH3D6l3vVCzQdvvkpC9elJQVFmbNLvjrDrSuHhGw79A1r8EYnxjBMezdKGPLOFcrucGPwRIe8T86wFZrNRuzgElLg4B2jAfgdShc60CLCnORLKZDwKhKhWoBZgR_V2GBEi--a1qx06_MNUqmheEvnaffz403kheZ4ew1g4NmGSXkF68HsR4zA0_MlYJyEOffgMeDKoF0vAxtdffHhEPVAbXcS2LzjhbSMcaBB3VD-7qCD7TiQJ412Djw-WMyeSknQQ0uVAE0ivHmQTqgO9Ds3pt_hK7Agm-C3_HBaLbNriAbKIU3zH-rO3GUbckQGs7icKsPL_dIKjYAWo19Knf_R8ljrUs8pwV3Xjuiz4sZbCR6BFL8XZSwkksSjdJaMPyvQ14b157tfxzay8i1gRhDNeKyMTW9R20OdcnTMJrR1VazwmCP_TB-qNNZcsG7B9ipk1MXZ-bs6gZ4flrCX7XJ-F=w1270-h940-no",
        "https://lh3.googleusercontent.com/wtFocF80GZgFceSGx79KBoxe1FTVfw2TpkPANTQDIoFfvc1nPiPnBSTqaOz-k7NgBygh8Y_-7f9KM3sR59BdAwsnF5VlDHx-AswUIrhfLgNCXtPRBYx9B-Caw6sV2pM4XNimKKP6ch8XyEgTNZ7sO4etVnuKHcjyovKYK6n92rnSFWRt0hcy7U7aejGYTmaBS0eYvdjB3RQ7kIQBQmqQIThjxty8jBCcNrMgooyszForC5XqIFEocden2-RY15zFlb5mHLf8Wy96MRvHHevFfkBa4hURGtpY3bkgsHoXCCDRSmxOB9-KP0JfC9Cs_rcipiswkoQO0v0Df0LHyrlu3KrbmM6EGtsohkbKy7k6FMQMiKdcMI_fsN3UNPtWF6Ynx3CFDaH10IouH50nQzS105bZnP7R1CaGKCAjrY7qXMY-PcdNtXEnaJFkNN2mnH6sEtNGmYjYVap-ZrkfDOU7DMfZNbW0NDvwy_VA0BOFABdGZn3gZeQDY9yn6zNJLtKgRDTnQTp5LF3MldWlxUo4bfbfIAgiQ56GJmPxWLjxvTgQt5Tr_LDJgMKe3UxTmD47i8AKCUXFd3xHNb1CnjgTeCcgLQVXq2oy=w1270-h950-no",
        "https://lh3.googleusercontent.com/qH8sY1z3KEtaebqcPby7IG_UuSqW4c2Z4qVT51Q36I0GT9tJChJ0fN8Psltn5cfjf7_RrV6xtWNx90VRXvroMbxYRMaNV9Mi-MM573VkHmoC8qB8mHDLWiA7ydoPhKXNr_SZTo7CJyUdO03Pon06Z_FyDD5pXsd1Ew6YhEhhGXqw7fQvEicvJdRFKZGqgqrpVMaYrlYMbOHCzgGRHEbp8q7OJRvQlbPBQW18-JLKs6GYv5h-LCTXWO2woRVTAC29UPuHO2VzeDyL9qtM1ub38iFnV7A4LuZQpIRFe8fSxDwCnFxw23W2TXpYvz-K5nqewtP4KcnH_272BlY24gvbJV-QoldeF9zazaDZi8pKhEr4q7vc8VQXHNFIehI9JSihZdNzQdsQiOW0mlrRT_h1M1TUL-9O7oFs9Bf_zy8nMxrM5RMbxA2ixo0sPyxI6vKWKy_LsRCD-z0UxjcysW_5EPVPxle_O4a-2ntobLvq3pFXqheegQiqFP1g6gMr_J3EFwGyRd1GSgKB8n30xX8EZo55rXXdvSmLFjlvZ-oWL9T_Q_zZSfu9r53hVfytiSPrZcNLJs_nhodZdNIg9YA6fbOfzkfjc5__=w1270-h950-no",
        "https://lh3.googleusercontent.com/C4dDYsG99mSbhJ6k9DtMnqzmLZKtugkt6xkUrDVcgkWXDCIFSFjltD39uvQS2OzbzrdGMYioU8AbOF03NtC89F74WZyA9VKvyfvMVwgXwNQ2BErFwyEtHtY1e3Ewl8gR-6Vb7hDp-XIgtRaBjuEYTIdDELxzEmAow1IaaNncF6z5T7nRziIfF0y1jscEN0AFgY8gtnpLnvUb2wxT7h3srEUyuctVozMKQbRleVmdjqMlI3ghs3D2dHWsxI1rh5VTsZhhzA4DOGZ6aFeUMZCBYXkMDFMl3zmmpzFADsePR1tOUsAktopmWSMKsYBR68kmMc5sakEtUYG9aYjVwWTFbrlkdul_tC3IZVYjFWb0QyVw7mBB9g6anWpw5aQBJ8MHFsRTJc3mkBbrtSXSnDyrHa1gStPRWJVbRIgHfkre-9LSRkVu1rbof5qaw9Kgbxhd4vJbO29FK8bKrjqrBYx0Xm582RXrXtKzb2pf8lcZOxHsXT1B45-2rMqxac20HUDFIJP7J_6DX8_yu-LdNGILBrgf0SI3y_kM3-mnkY7E439FTXdE6MBxDB3Hl7NNaf0yhQ5B4WKezqPYYTg-MuWN693YAm8f7eZm=w1270-h950-no",
        "https://lh3.googleusercontent.com/X7LeBu-pcZT072M2mtywDQWCKuqTMjdCWrrAaofQI7_6=w950-h713-no",
        "https://lh3.googleusercontent.com/srl6bOcG8KT0SdlEtkgxvGJOjKh22kWLBLrS25McOUsm=w950-h713-no",
        "https://lh3.googleusercontent.com/uOZbJGuX8Ut5j-Yw2IfzaCe30rdrbD93fmZI1bRLRHR7=w950-h706-no",
        "https://lh3.googleusercontent.com/X2g2LKEruoxITTE1hXG5Lp3tJALhptCDp0gKZ932SWwt=w950-h713-no",
        "https://lh3.googleusercontent.com/EuGPCu0gYpWneIYHFayUDcNK7qrifvWwIYYoFMFu6TP3=w950-h713-no",
        "https://lh3.googleusercontent.com/7QQGcjlShMdu7sXchzLUexsA8BScXnOe82baYOysAZmk=w950-h713-no",
        "https://lh3.googleusercontent.com/5H2ql2TAP0dw_U2kNEP9__nbyBrbvX9Lek0qW3i2K-rF=w950-h713-no",
        "https://lh3.googleusercontent.com/6iA-Q8DyXPOIASEJWMBU1szFzd9isijp5HbDhB17-Q-O=w950-h713-no"
    );

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.network_image_view);
        init();
    }

    private void init()
    {
        setUpToolbar();
        setUpRecyclerView();
    }

    private void setUpToolbar()
    {
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

        if (getSupportActionBar() != null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    private void setUpRecyclerView()
    {
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setAdapter(new NetworkImageRecyclerViewAdapter(sImages));
    }
}