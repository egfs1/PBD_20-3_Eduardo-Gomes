PGDMP     ,    "            	    x            SistemaEniatus    12.4    12.4 !    <           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            =           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            >           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            ?           1262    41101    SistemaEniatus    DATABASE     �   CREATE DATABASE "SistemaEniatus" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Portuguese_Brazil.1252' LC_CTYPE = 'Portuguese_Brazil.1252';
     DROP DATABASE "SistemaEniatus";
                postgres    false            �            1259    58014    hibernate_sequence    SEQUENCE     {   CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.hibernate_sequence;
       public          postgres    false            �            1259    58016    mesdereferencia    TABLE     �   CREATE TABLE public.mesdereferencia (
    id bigint NOT NULL,
    idinss bigint,
    idirrf bigint,
    idsalariofamilia bigint,
    idsalariominimo bigint,
    vigencia timestamp without time zone
);
 #   DROP TABLE public.mesdereferencia;
       public         heap    postgres    false            �            1259    58021    pessoa    TABLE     �  CREATE TABLE public.pessoa (
    id bigint NOT NULL,
    dataadmissao timestamp without time zone,
    datanascimento timestamp without time zone,
    funcao character varying(255),
    horassemanaiscontratadas integer,
    naturalidade character varying(255),
    nome character varying(255),
    qntfilhos integer,
    senha character varying(255),
    sindicalizado boolean,
    tipo character varying(255),
    usuario character varying(255)
);
    DROP TABLE public.pessoa;
       public         heap    postgres    false            �            1259    58029    requestresetsenha    TABLE     �   CREATE TABLE public.requestresetsenha (
    id bigint NOT NULL,
    datarequest timestamp without time zone,
    idpessoa bigint
);
 %   DROP TABLE public.requestresetsenha;
       public         heap    postgres    false            �            1259    58034 
   tabelainss    TABLE     �   CREATE TABLE public.tabelainss (
    id bigint NOT NULL,
    idvalorinss1 bigint,
    idvalorinss2 bigint,
    idvalorinss3 bigint,
    idvalorinss4 bigint,
    vigencia timestamp without time zone
);
    DROP TABLE public.tabelainss;
       public         heap    postgres    false            �            1259    58039 
   tabelairrf    TABLE     �   CREATE TABLE public.tabelairrf (
    id bigint NOT NULL,
    idvalorirrf1 bigint,
    idvalorirrf2 bigint,
    idvalorirrf3 bigint,
    idvalorirrf4 bigint,
    idvalorirrf5 bigint,
    vigencia timestamp without time zone
);
    DROP TABLE public.tabelairrf;
       public         heap    postgres    false            �            1259    58044    tabelasalariofamilia    TABLE     �   CREATE TABLE public.tabelasalariofamilia (
    id bigint NOT NULL,
    remuneracaomensal double precision,
    valorunitario double precision,
    vigencia timestamp without time zone
);
 (   DROP TABLE public.tabelasalariofamilia;
       public         heap    postgres    false            �            1259    58049    tabelasalariominimo    TABLE     �   CREATE TABLE public.tabelasalariominimo (
    id bigint NOT NULL,
    valor double precision,
    vigencia timestamp without time zone
);
 '   DROP TABLE public.tabelasalariominimo;
       public         heap    postgres    false            �            1259    58054    valoresinss    TABLE     �   CREATE TABLE public.valoresinss (
    id bigint NOT NULL,
    aliquota double precision,
    valormaximo double precision,
    valorminimo double precision
);
    DROP TABLE public.valoresinss;
       public         heap    postgres    false            �            1259    58059    valoresirrf    TABLE     �   CREATE TABLE public.valoresirrf (
    id bigint NOT NULL,
    aliquota double precision,
    valordeduzir double precision,
    valormaximo double precision,
    valorminimo double precision
);
    DROP TABLE public.valoresirrf;
       public         heap    postgres    false            1          0    58016    mesdereferencia 
   TABLE DATA           j   COPY public.mesdereferencia (id, idinss, idirrf, idsalariofamilia, idsalariominimo, vigencia) FROM stdin;
    public          postgres    false    203   W'       2          0    58021    pessoa 
   TABLE DATA           �   COPY public.pessoa (id, dataadmissao, datanascimento, funcao, horassemanaiscontratadas, naturalidade, nome, qntfilhos, senha, sindicalizado, tipo, usuario) FROM stdin;
    public          postgres    false    204   �'       3          0    58029    requestresetsenha 
   TABLE DATA           F   COPY public.requestresetsenha (id, datarequest, idpessoa) FROM stdin;
    public          postgres    false    205   (       4          0    58034 
   tabelainss 
   TABLE DATA           j   COPY public.tabelainss (id, idvalorinss1, idvalorinss2, idvalorinss3, idvalorinss4, vigencia) FROM stdin;
    public          postgres    false    206   2(       5          0    58039 
   tabelairrf 
   TABLE DATA           x   COPY public.tabelairrf (id, idvalorirrf1, idvalorirrf2, idvalorirrf3, idvalorirrf4, idvalorirrf5, vigencia) FROM stdin;
    public          postgres    false    207   i(       6          0    58044    tabelasalariofamilia 
   TABLE DATA           ^   COPY public.tabelasalariofamilia (id, remuneracaomensal, valorunitario, vigencia) FROM stdin;
    public          postgres    false    208   �(       7          0    58049    tabelasalariominimo 
   TABLE DATA           B   COPY public.tabelasalariominimo (id, valor, vigencia) FROM stdin;
    public          postgres    false    209   �(       8          0    58054    valoresinss 
   TABLE DATA           M   COPY public.valoresinss (id, aliquota, valormaximo, valorminimo) FROM stdin;
    public          postgres    false    210   ))       9          0    58059    valoresirrf 
   TABLE DATA           [   COPY public.valoresirrf (id, aliquota, valordeduzir, valormaximo, valorminimo) FROM stdin;
    public          postgres    false    211   x)       @           0    0    hibernate_sequence    SEQUENCE SET     A   SELECT pg_catalog.setval('public.hibernate_sequence', 21, true);
          public          postgres    false    202            �
           2606    58020 $   mesdereferencia mesdereferencia_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public.mesdereferencia
    ADD CONSTRAINT mesdereferencia_pkey PRIMARY KEY (id);
 N   ALTER TABLE ONLY public.mesdereferencia DROP CONSTRAINT mesdereferencia_pkey;
       public            postgres    false    203            �
           2606    58028    pessoa pessoa_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.pessoa
    ADD CONSTRAINT pessoa_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.pessoa DROP CONSTRAINT pessoa_pkey;
       public            postgres    false    204            �
           2606    58033 (   requestresetsenha requestresetsenha_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY public.requestresetsenha
    ADD CONSTRAINT requestresetsenha_pkey PRIMARY KEY (id);
 R   ALTER TABLE ONLY public.requestresetsenha DROP CONSTRAINT requestresetsenha_pkey;
       public            postgres    false    205            �
           2606    58038    tabelainss tabelainss_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.tabelainss
    ADD CONSTRAINT tabelainss_pkey PRIMARY KEY (id);
 D   ALTER TABLE ONLY public.tabelainss DROP CONSTRAINT tabelainss_pkey;
       public            postgres    false    206            �
           2606    58043    tabelairrf tabelairrf_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.tabelairrf
    ADD CONSTRAINT tabelairrf_pkey PRIMARY KEY (id);
 D   ALTER TABLE ONLY public.tabelairrf DROP CONSTRAINT tabelairrf_pkey;
       public            postgres    false    207            �
           2606    58048 .   tabelasalariofamilia tabelasalariofamilia_pkey 
   CONSTRAINT     l   ALTER TABLE ONLY public.tabelasalariofamilia
    ADD CONSTRAINT tabelasalariofamilia_pkey PRIMARY KEY (id);
 X   ALTER TABLE ONLY public.tabelasalariofamilia DROP CONSTRAINT tabelasalariofamilia_pkey;
       public            postgres    false    208            �
           2606    58053 ,   tabelasalariominimo tabelasalariominimo_pkey 
   CONSTRAINT     j   ALTER TABLE ONLY public.tabelasalariominimo
    ADD CONSTRAINT tabelasalariominimo_pkey PRIMARY KEY (id);
 V   ALTER TABLE ONLY public.tabelasalariominimo DROP CONSTRAINT tabelasalariominimo_pkey;
       public            postgres    false    209            �
           2606    58058    valoresinss valoresinss_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.valoresinss
    ADD CONSTRAINT valoresinss_pkey PRIMARY KEY (id);
 F   ALTER TABLE ONLY public.valoresinss DROP CONSTRAINT valoresinss_pkey;
       public            postgres    false    210            �
           2606    58063    valoresirrf valoresirrf_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.valoresirrf
    ADD CONSTRAINT valoresirrf_pkey PRIMARY KEY (id);
 F   ALTER TABLE ONLY public.valoresirrf DROP CONSTRAINT valoresirrf_pkey;
       public            postgres    false    211            1   )   x�32��44�4�4�4202�54�50T00�#�=... nq�      2   u   x�u̱�0F��<���c 6����d)������U�x����~ГȦ��<�%�����G�oCjF��0���j�r��R#&��Ⱥ`�h����"�/�@�n����	����'���%�      3      x������ � �      4   '   x���4�4�4�4�4202�54�50T00�#�=... b�      5   @   x�Uʻ�0�x�
0�9��]��a�H,M6��.,)��邋�����C����bQ�~�      6   -   x�3�4412�35�4��33�4202�54�50T00�#�=... ��      7   #   x�3�40�4202�54�50T00�#�=... T�$      8   ?   x�-��� Cѳ=LdC�.�������+bac����	���gF^2�hˡ�f�A���      9   f   x�}��	C1D�����5�zI�uĐ�MF�;�3�s>�:7l-�
mD���wx!k���\����I��"��;;9?�9������ͱ/��;��x���.4.�     