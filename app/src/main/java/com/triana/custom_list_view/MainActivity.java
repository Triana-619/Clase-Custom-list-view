package com.triana.custom_list_view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    ListView listaPersona;
    HashMap<String, Integer> visitCountMap = new HashMap<>(); // Contador de visitas
    String selectedItemID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[] fotoPerfil = {
                R.drawable.primo,
                R.drawable.juice1,
                R.drawable.juice2,
                R.drawable.juice3,
                R.drawable.juice4,
        };
        String[] nombres = {
                "Juicewrdl",
                "mac miller producción",
                "Lil peep",
                "Post malone",
                "mac miller",
        };
        String[] biografias = {
                "¿Quién es Juice Wrld?\n" +
                        "\n" +
                        "Jarad Anthony Higgins, quien lleva por nombre artístico Juice Wrld, fue un exponente de rap, cantante y compositor estadounidense de Calumet Park, Illinois, que nació el 2 de diciembre de 1998, en Chicago, Illinois, EE.UU, y falleció el 8 de diciembre de 2019, tras sufrir una convulsión en el aeropuerto Midway de Chicago. Fue principalmente conocido por sus canciones, \"All Girls Are the Same\" y \"Lucid Dreams”. Su música ha sido descrita como \"emo rap”.\n" +
                        "\n" +
                        "Significado del nombre\n" +
                        "\n" +
                        "En una entrevista con “Mass Appeal”, Juice WRLD explica cómo se le ocurrió su nombre artístico. El dijo en la entrevista que: \"Tenía el corte de pelo, como el corte que llevaba el rapero Tupac Shakur en su película “Juice”. Y referente a la parte de WLRD indica que Lo tomó como una referencia de tratar de conquistar el mundo, y el ser su propio mundo\".",
                "Warner Music Group (WMG) también conocido como Warner Music, es un conglomerado de entretenimiento y sello discográfico estadounidense con sede en la ciudad de Nueva York. Es la tercera más grande de las \"tres grandes\" compañías discográficas mundiales después de Sony Music Entertainment (SME) y Universal Music Group (UMG), respectivamente. Era una división de Time Warner (ahora Warner Bros. Discovery). La compañía cotizó en la Bolsa de Nueva York hasta mayo de 2011, cuando anunció su privatización y venta a Access Industries, que se completó en julio de 2011. Con una facturación anual de miles de millones de dólares, WMG emplea a más de 3500 personas y tiene operaciones en más de 50 países en todo el mundo.\n" +
                        "\n" +
                        "La compañía posee y opera algunos de los sellos más grandes y exitosos del mundo, incluyendo Elektra Records, Warner Bros. Records, Parlophone y Atlantic Records. WMG también es dueño de Warner / Chappell Music, una de las editoriales de música más grandes del mundo.",
                "¿Quién es Lil Peep?\n" +
                        "\n" +
                        "Gustav Elijah Åhr, mejor conocido por su nombre artístico Lil Peep, fue un cantante y rapero estadounidense del género emo hip hop que nació el 01 de noviembre de 1996 en el estado de Virginia de Estados Unidos, pero se crió en Long Island, Nueva York, y falleció el 15 de noviembre de 2017 en Tucson, Arizona, EE.UU. por una supuesta sobredosis de Alprazolam.\n" +
                        "\n" +
                        "Lil Peep es considerado uno de los artistas responsables por la revitalización del estilo de música post-emo y por crear su propio estilo de hip hop, el cual se llegó a conocer como \"emo hip hop\".\n" +
                        "\n" +
                        "Lil Peep asistio a la secundaria Long Beach High School en Lido Beach, Nueva York, donde raramente se presentó a clases a pesar de tener buenas calificaciones. Luego abandonó la escuela para tomar cursos en línea y recibir su diploma. Poco después de eso empezó a publicar sus videos musicales en YouTube y SoundCloud.\n" +
                        "\n" +
                        "Cuando tenía 17 años se mudó a Los Ángeles, California, para desarrollar su carrera musical.\n" +
                        "\n" +
                        "Niñez, Juventud y Vida Familiar\n" +
                        "\n" +
                        "Gustav Elijah Åhr (Lil Peep) nació en Allentown, Pennsylvania, como hijo de la maestra de primer grado Liza Womack y el profesor universitario Karl Johan Åhr. Tenía un hermano de nombre Karl \"Oskar\" Åhr. El joven cantante creció en Long Island, Nueva York. Sus padres eran ambos graduados de Harvard y se divorciaron cuando era un adolescente.",
                "¿Quién es Post Malone?\n" +
                        "\n" +
                        "Austin Richard Post, quien se hace llamar Post Malone en el medio artístico y musical, es un músico, cantante, intérprete de rap y productor. Nació el 4 de julio de 1995 en Siracusa, Nueva York, Estados Unidos. Se dio a conocer con su sencillo debut “White Iverson”. Después estrenó “Congratulations”, junto a Switchblades, que se convirtió en su canción más escuchada hasta el momento; además de la canción “Rockstar”, junto a 21 Savage, que le permitió conseguir un contrato con el sello discográfico Republic Records.\n" +
                        "\n" +
                        "Significado del nombre\n" +
                        "\n" +
                        "Luego de culminar sus estudios universitarios se mudó a Los Ángeles, California, Estados Unidos, allí asumió el nombre artístico Post Malone; se pensó que era en honor al jugador profesional de baloncesto Karl Malone, pero en realidad fue resultado de introducir su verdadero nombre en un generador online de seudónimos para raperos.",
                "¿Quién es Mac Miller?\n" +
                        "\n" +
                        "Malcolm James McCormick, más conocido por su nombre artístico Mac Miller, fue un rapero estadounidense que nació en Pittsburgh, Pensilvania, Estados Unidos, el 19 de enero de 1992 y falleció el 7 de septiembre de 2018. También fue un músico autodidacta, tocaba el piano, el bajo, la guitarra y la batería.\n" +
                        "\n" +
                        "Ha destacado como productor bajo el seudónimo Larry Fisherman.\n" +
                        "\n" +
                        "Niñez, Juventud y Vida Familiar\n" +
                        "\n" +
                        "Hijo de Karen Meyers, una fotógrafa, y Mark McCormick, un arquitecto. Su padre es cristiano y su madre es judía. Miller fue criado en el Breeze Point de Pittsburgh bajo la religión judía. Asistió a la Escuela Winchester Thurston y Taylor Allderdice.\n" +
                        "\n" +
                        "Decidió centrarse en su carrera en el hip hop y dejar de lado los estudios, aunque no se lo tomaba muy seriamente, más tarde señaló en una entrevista: \"Tengo serias verdades acerca de ello, y cambió mi vida completamente…, yo solía hacer deporte, jugaba a todos los deportes, e iba a todas las fiestas de la preparatoria, pero una vez me enteré que el hip hop es casi como un trabajo, y a partir de entonces, me lo tomé mucho más en serio y no he parado desde que cumplí 15 años\".\n" +
                        "\n" +
                        "Cuando comenzó su carrera tenía su apodo Easy Mac, que luego fue cambiado al actual Mac Miller. Antes de su carrera en solitario, formó parte del grupo de rap The Ill Spoken con su colega rapero de Pittsburgh, Beedie. Al cumplir los 18 años, firmó con Rostrum Records y lanzó su debut mixtape, titulada K.I.D.S. en agosto de 2010.",
        };
        String[] telefonos = {
                "12K",
                "5K",
                "8K",
                "13.1K",
                "25.3K",
        };

        ListAdapter personas = new ListAdapter(MainActivity.this,nombres,telefonos,fotoPerfil,biografias,visitCountMap);
        listaPersona = (ListView) findViewById(R.id.listaUsuario);
        listaPersona.setAdapter(personas);

        listaPersona.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> Lista, View Vista, int Posicion, long Id){

                // Guarda el ID del ítem seleccionado
                selectedItemID = nombres[Posicion];

                if (selectedItemID != null) {
                    int visitCount = visitCountMap.getOrDefault(selectedItemID, 0);
                    visitCountMap.put(selectedItemID, visitCount + 1);
                }

                // Notifica al adaptador que los datos han cambiado
                personas.notifyDataSetChanged();

                Intent EnviarInfo = new Intent(MainActivity.this, UserActivity.class)
                        .putExtra("Nombre: ", nombres[Posicion])
                        .putExtra("Teléfono: ", telefonos[Posicion])
                        .putExtra("Foto de Perfil: ", fotoPerfil[Posicion])
                        .putExtra("Biografia: ", biografias[Posicion]);
                startActivity(EnviarInfo);
            }
        });

    }
}

