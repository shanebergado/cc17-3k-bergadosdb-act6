package com.example.a30dayapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)


        val days = listOf(
            Day(1, "Creamy Broccoli Tortellini", "Creamy Broccoli Tortellini combines tender tortellini pasta and fresh broccoli in a rich, creamy sauce of heavy cream, garlic, and Parmesan cheese, creating a comforting and flavorful dish perfect for any occasion.", R.drawable.pasta1),
            Day(2, "Pappardelle Pasta with Bacon Leeks and Mushrooms", "Pappardelle Pasta with Bacon, Leeks, and Mushrooms features wide, ribbon-like pasta tossed in a savory sauce of crispy bacon, sautéed leeks, and earthy mushrooms, creating a rich and comforting dish that's perfect for a hearty meal.", R.drawable.pasta2),
            Day(3, "The Best Crab Linguine", "The Best Crab Linguine is a delightful dish featuring al dente linguine pasta tossed in a light, flavorful sauce with succulent crab meat, garlic, cherry tomatoes, and fresh herbs, creating a perfect balance of taste and freshness.", R.drawable.pasta3),
            Day(4, "Bacon and Egg Pasta", "Bacon and Egg Pasta is a comforting dish that combines al dente pasta with crispy bacon, sautéed garlic, and a rich, creamy sauce made from beaten eggs and Parmesan cheese, resulting in a deliciously indulgent meal.", R.drawable.pasta4),
            Day(5, "Fresh Herb Tomato Pasta", "Fresh Herb Tomato Pasta features al dente pasta tossed in a vibrant sauce of ripe tomatoes, aromatic fresh herbs, garlic, and olive oil, creating a light and flavorful dish that highlights the freshness of its ingredients.", R.drawable.pasta5),
            Day(6, "Spicy Chicken Spaghetti Stir-Fry", "Spicy Chicken Spaghetti Stir-Fry is a zesty dish that combines tender chicken, colorful vegetables, and spaghetti noodles stir-fried in a bold, spicy sauce, delivering a satisfying and flavorful meal with a perfect balance of heat and freshness.", R.drawable.pasta6),
            Day(7, "Creamy Chicken Fettuccine", "Creamy Chicken Fettuccine features tender fettuccine pasta tossed with succulent chicken in a rich, velvety cream sauce made from garlic, Parmesan, and herbs, creating a comforting and indulgent dish.", R.drawable.pasta7),
            Day(8, "Cauliflower Garlic Pasta", "Cauliflower Garlic Pasta is a light yet flavorful dish combining al dente pasta with roasted cauliflower, sautéed garlic, olive oil, and a sprinkle of Parmesan, delivering a simple and wholesome meal.", R.drawable.pasta8),
            Day(9, "Pasta Bake Roasted Vegetables", "Pasta Bake with Roasted Vegetables features al dente pasta baked with a medley of caramelized, roasted vegetables, layered in a savory tomato sauce, and topped with melted cheese for a hearty and flavorful dish.", R.drawable.pasta9),
            Day(10, "Italian Comfort Spaghetti", "Italian Comfort Spaghetti is a classic, heartwarming dish featuring al dente spaghetti tossed in a rich tomato sauce with garlic, herbs, and a sprinkle of Parmesan, offering simple yet satisfying flavors.", R.drawable.pasta10),
            Day(11, "Shrimp and Salami Pasta", "Shrimp and Salami Pasta combines tender shrimp and savory salami with al dente pasta in a flavorful sauce of garlic, olive oil, and herbs, creating a unique and hearty dish with a delightful contrast of flavors.", R.drawable.pasta11),
            Day(12, "Mushroom Fettuccine", "Mushroom Fettuccine features tender fettuccine pasta tossed in a creamy, garlic-infused sauce with sautéed mushrooms, creating a rich and earthy dish perfect for mushroom lovers.", R.drawable.pasta12),
            Day(13, "Garlic Broccoli Pasta", "Garlic Broccolini Pasta combines al dente pasta with crisp-tender broccolini sautéed in olive oil and garlic, creating a simple yet flavorful dish that's both light and satisfying.", R.drawable.pasta13),
            Day(14, "White Ragù Pappardelle", "White Ragù Pappardelle features wide pappardelle noodles tossed in a rich, creamy white ragù sauce made with ground meat, garlic, white wine, and herbs, creating a hearty and comforting dish.", R.drawable.pasta14),
            Day(15, "Garlic and Chili Shrimp Pasta", "Garlic and Chili Shrimp Pasta combines succulent shrimp with al dente pasta in a bold, zesty sauce of garlic, olive oil, and red chili flakes, delivering a spicy and flavorful meal.", R.drawable.pasta15),
            Day(16, "Creamy Pappardelle", "Creamy Pappardelle features wide pappardelle noodles enveloped in a luscious, velvety cream sauce made with garlic, Parmesan, and herbs, creating a rich and indulgent pasta dish.", R.drawable.pasta16),
            Day(17, "Italian Lemon Pasta", "Italian Lemon Pasta is a refreshing dish featuring al dente pasta tossed in a bright and zesty lemon sauce, complemented by garlic, olive oil, and fresh herbs for a light and flavorful meal.", R.drawable.pasta17),
            Day(18, "Fish Linguine","Fish Linguine features tender linguine pasta tossed with fresh fish, garlic, and a light white wine sauce, creating a delicate and flavorful dish that highlights the ocean's bounty.",R.drawable.pasta18),
            Day(19, "Homemade Meat Ravioli","Homemade Meat Ravioli are tender pasta pillows filled with a savory mixture of seasoned ground meat, herbs, and cheese, served with a rich tomato sauce or a creamy Alfredo for a comforting and satisfying meal.",R.drawable.pasta18),
            Day(20, "Roasted Squash and Sage Spaghetti", "Roasted Squash and Sage Spaghetti features al dente spaghetti tossed with sweet roasted squash, fragrant sage, and a drizzle of olive oil, creating a comforting and flavorful dish that celebrates the essence of autumn.", R.drawable.pasta20),
            Day(21, "Penne Pasta with Tuna and Peas", "Penne Pasta with Tuna and Peas is a quick and satisfying dish that combines al dente penne pasta with flaky tuna, sweet peas, and a light cream or olive oil sauce, delivering a flavorful and nutritious meal.", R.drawable.pasta21),
            Day(22, "Fried Eggplant Pasta", "Fried Eggplant Pasta features al dente pasta tossed with crispy fried eggplant, garlic, and a rich tomato sauce, creating a deliciously hearty and satisfying dish with a delightful texture contrast.", R.drawable.pasta22),
            Day(23, "20 Minute Lemon Salmon Pasta", "20 Minute Lemon Salmon Pasta is a quick and easy dish that combines al dente pasta with flaky salmon, bright lemon juice, and fresh herbs, delivering a light and flavorful meal ready in just twenty minutes.", R.drawable.pasta23),
            Day(24, "Pasta alla Genovese", "Pasta alla Genovese is a traditional Italian dish that features al dente pasta coated in a rich, slow-cooked onion sauce, enriched with tender chunks of meat and flavored with herbs, creating a comforting and savory meal.", R.drawable.pasta24),
            Day(25, "Garlic and Chili Tuna Pasta", "Garlic and Chili Tuna Pasta combines al dente pasta with flaky tuna, sautéed garlic, and a kick of chili flakes, creating a flavorful and quick dish that's both satisfying and easy to prepare.", R.drawable.pasta25),
            Day(26, "French Spaghetti Carbonara", "French Spaghetti Carbonara is a creamy twist on the classic dish, featuring al dente spaghetti tossed with crispy pancetta, eggs, and a rich blend of cheese, enhanced with a touch of fresh herbs for a delightful flavor profile.", R.drawable.pasta26),
            Day(27, "Spinach Cannelloni", "Spinach Cannelloni features tubular pasta filled with a savory mixture of ricotta cheese and fresh spinach, baked in a rich tomato sauce and topped with melted cheese for a comforting and delicious Italian dish", R.drawable.pasta27),
            Day(28, "Ragù Alla Bolognese", "Ragù alla Bolognese is a traditional Italian meat sauce made with ground beef, pork, or veal, slowly simmered with tomatoes, onions, carrots, and aromatic herbs, creating a rich and hearty sauce typically served with pasta.", R.drawable.pasta28),
            Day(29, "Spaghetti and Meatballs", "Spaghetti and Meatballs is a classic Italian-American dish featuring al dente spaghetti topped with tender, flavorful meatballs simmered in a rich marinara sauce, creating a hearty and satisfying meal.", R.drawable.pasta29),
            Day(30, "Eggplant Rigatoni", "Eggplant Rigatoni features hearty rigatoni pasta tossed with tender roasted eggplant, garlic, and a rich tomato sauce, creating a flavorful and comforting vegetarian dish.", R.drawable.pasta30)


        )

        adapter = ListAdapter(this, days)
        recyclerView.adapter = adapter
    }
}
