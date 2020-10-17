PGDMP     9                	    x            SistemaEniatus    12.4    12.4 $    C           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            D           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            E           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            F           1262    41101    SistemaEniatus    DATABASE     �   CREATE DATABASE "SistemaEniatus" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Portuguese_Brazil.1252' LC_CTYPE = 'Portuguese_Brazil.1252';
     DROP DATABASE "SistemaEniatus";
                postgres    false            �            1259    58115    hibernate_sequence    SEQUENCE     {   CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.hibernate_sequence;
       public          postgres    false            �            1259    58117    log    TABLE     |   CREATE TABLE public.log (
    id bigint NOT NULL,
    data timestamp without time zone,
    texto character varying(255)
);
    DROP TABLE public.log;
       public         heap    postgres    false            �            1259    58122    mesdereferencia    TABLE     �   CREATE TABLE public.mesdereferencia (
    id bigint NOT NULL,
    idinss bigint,
    idirrf bigint,
    idsalariofamilia bigint,
    idsalariominimo bigint,
    vigencia timestamp without time zone
);
 #   DROP TABLE public.mesdereferencia;
       public         heap    postgres    false            �            1259    58127    pessoa    TABLE     �  CREATE TABLE public.pessoa (
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
       public         heap    postgres    false            �            1259    58135    requestresetsenha    TABLE     �   CREATE TABLE public.requestresetsenha (
    id bigint NOT NULL,
    datarequest timestamp without time zone,
    idpessoa bigint
);
 %   DROP TABLE public.requestresetsenha;
       public         heap    postgres    false            �            1259    58140 
   tabelainss    TABLE     �   CREATE TABLE public.tabelainss (
    id bigint NOT NULL,
    idvalorinss1 bigint,
    idvalorinss2 bigint,
    idvalorinss3 bigint,
    idvalorinss4 bigint,
    vigencia timestamp without time zone
);
    DROP TABLE public.tabelainss;
       public         heap    postgres    false            �            1259    58145 
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
       public         heap    postgres    false            �            1259    58150    tabelasalariofamilia    TABLE     �   CREATE TABLE public.tabelasalariofamilia (
    id bigint NOT NULL,
    remuneracaomensal double precision,
    valorunitario double precision,
    vigencia timestamp without time zone
);
 (   DROP TABLE public.tabelasalariofamilia;
       public         heap    postgres    false            �            1259    58155    tabelasalariominimo    TABLE     �   CREATE TABLE public.tabelasalariominimo (
    id bigint NOT NULL,
    valor double precision,
    vigencia timestamp without time zone
);
 '   DROP TABLE public.tabelasalariominimo;
       public         heap    postgres    false            �            1259    58160    valoresinss    TABLE     �   CREATE TABLE public.valoresinss (
    id bigint NOT NULL,
    aliquota double precision,
    valormaximo double precision,
    valorminimo double precision
);
    DROP TABLE public.valoresinss;
       public         heap    postgres    false            �            1259    58165    valoresirrf    TABLE     �   CREATE TABLE public.valoresirrf (
    id bigint NOT NULL,
    aliquota double precision,
    valordeduzir double precision,
    valormaximo double precision,
    valorminimo double precision
);
    DROP TABLE public.valoresirrf;
       public         heap    postgres    false            7          0    58117    log 
   TABLE DATA           .   COPY public.log (id, data, texto) FROM stdin;
    public          postgres    false    203   3*       8          0    58122    mesdereferencia 
   TABLE DATA           j   COPY public.mesdereferencia (id, idinss, idirrf, idsalariofamilia, idsalariominimo, vigencia) FROM stdin;
    public          postgres    false    204   �+       9          0    58127    pessoa 
   TABLE DATA           �   COPY public.pessoa (id, dataadmissao, datanascimento, funcao, horassemanaiscontratadas, naturalidade, nome, qntfilhos, senha, sindicalizado, tipo, usuario) FROM stdin;
    public          postgres    false    205   �+       :          0    58135    requestresetsenha 
   TABLE DATA           F   COPY public.requestresetsenha (id, datarequest, idpessoa) FROM stdin;
    public          postgres    false    206   v,       ;          0    58140 
   tabelainss 
   TABLE DATA           j   COPY public.tabelainss (id, idvalorinss1, idvalorinss2, idvalorinss3, idvalorinss4, vigencia) FROM stdin;
    public          postgres    false    207   �,       <          0    58145 
   tabelairrf 
   TABLE DATA           x   COPY public.tabelairrf (id, idvalorirrf1, idvalorirrf2, idvalorirrf3, idvalorirrf4, idvalorirrf5, vigencia) FROM stdin;
    public          postgres    false    208   �,       =          0    58150    tabelasalariofamilia 
   TABLE DATA           ^   COPY public.tabelasalariofamilia (id, remuneracaomensal, valorunitario, vigencia) FROM stdin;
    public          postgres    false    209   �,       >          0    58155    tabelasalariominimo 
   TABLE DATA           B   COPY public.tabelasalariominimo (id, valor, vigencia) FROM stdin;
    public          postgres    false    210   �,       ?          0    58160    valoresinss 
   TABLE DATA           M   COPY public.valoresinss (id, aliquota, valormaximo, valorminimo) FROM stdin;
    public          postgres    false    211   -       @          0    58165    valoresirrf 
   TABLE DATA           [   COPY public.valoresirrf (id, aliquota, valordeduzir, valormaximo, valorminimo) FROM stdin;
    public          postgres    false    212   $-       G           0    0    hibernate_sequence    SEQUENCE SET     A   SELECT pg_catalog.setval('public.hibernate_sequence', 16, true);
          public          postgres    false    202            �
           2606    58121    log log_pkey 
   CONSTRAINT     J   ALTER TABLE ONLY public.log
    ADD CONSTRAINT log_pkey PRIMARY KEY (id);
 6   ALTER TABLE ONLY public.log DROP CONSTRAINT log_pkey;
       public            postgres    false    203            �
           2606    58126 $   mesdereferencia mesdereferencia_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public.mesdereferencia
    ADD CONSTRAINT mesdereferencia_pkey PRIMARY KEY (id);
 N   ALTER TABLE ONLY public.mesdereferencia DROP CONSTRAINT mesdereferencia_pkey;
       public            postgres    false    204            �
           2606    58134    pessoa pessoa_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.pessoa
    ADD CONSTRAINT pessoa_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.pessoa DROP CONSTRAINT pessoa_pkey;
       public            postgres    false    205            �
           2606    58139 (   requestresetsenha requestresetsenha_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY public.requestresetsenha
    ADD CONSTRAINT requestresetsenha_pkey PRIMARY KEY (id);
 R   ALTER TABLE ONLY public.requestresetsenha DROP CONSTRAINT requestresetsenha_pkey;
       public            postgres    false    206            �
           2606    58144    tabelainss tabelainss_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.tabelainss
    ADD CONSTRAINT tabelainss_pkey PRIMARY KEY (id);
 D   ALTER TABLE ONLY public.tabelainss DROP CONSTRAINT tabelainss_pkey;
       public            postgres    false    207            �
           2606    58149    tabelairrf tabelairrf_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.tabelairrf
    ADD CONSTRAINT tabelairrf_pkey PRIMARY KEY (id);
 D   ALTER TABLE ONLY public.tabelairrf DROP CONSTRAINT tabelairrf_pkey;
       public            postgres    false    208            �
           2606    58154 .   tabelasalariofamilia tabelasalariofamilia_pkey 
   CONSTRAINT     l   ALTER TABLE ONLY public.tabelasalariofamilia
    ADD CONSTRAINT tabelasalariofamilia_pkey PRIMARY KEY (id);
 X   ALTER TABLE ONLY public.tabelasalariofamilia DROP CONSTRAINT tabelasalariofamilia_pkey;
       public            postgres    false    209            �
           2606    58159 ,   tabelasalariominimo tabelasalariominimo_pkey 
   CONSTRAINT     j   ALTER TABLE ONLY public.tabelasalariominimo
    ADD CONSTRAINT tabelasalariominimo_pkey PRIMARY KEY (id);
 V   ALTER TABLE ONLY public.tabelasalariominimo DROP CONSTRAINT tabelasalariominimo_pkey;
       public            postgres    false    210            �
           2606    58164    valoresinss valoresinss_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.valoresinss
    ADD CONSTRAINT valoresinss_pkey PRIMARY KEY (id);
 F   ALTER TABLE ONLY public.valoresinss DROP CONSTRAINT valoresinss_pkey;
       public            postgres    false    211            �
           2606    58169    valoresirrf valoresirrf_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.valoresirrf
    ADD CONSTRAINT valoresirrf_pkey PRIMARY KEY (id);
 F   ALTER TABLE ONLY public.valoresirrf DROP CONSTRAINT valoresirrf_pkey;
       public            postgres    false    212            7   �  x�͕�n� ������"�`c�]�Dݺ C$ZKަc�#/V�D�B��QZ%�w����t.fS�H���Wňa6{�Q�A��W9�@氕J�0�\E�g�GItX&I���褤V&�Ճ�.��RGh]�p%�2�AvFIu8Q2�M��oM�mp���(m��ѕ��Χ���O�U�M2���T"�77&�ΆAD<\�!�^��J��4cj�;<�^7���x�;����R�0�*�o�p��w�s��Ո�[��o�EΝ:�FT�w�]g�nx��d
܂���5�@�LO�;'98;���~NC�������2i��b�+�)���%9��t�Θ��ݏ�zcwz�u�=���!1��h��.�S�Q-�	��ޜ(��L��  _U�q�      8      x������ � �      9   y   x�M�=� @�ٜ�hd�OQ��7�b0HHi� ���M��4>��=W�+�řpw�~o�֣����!vuϵ7���.2b*�X,�`���_!y],%���'��yb�멶E)��N%�      :      x������ � �      ;      x������ � �      <      x������ � �      =      x������ � �      >      x������ � �      ?      x������ � �      @      x������ � �     