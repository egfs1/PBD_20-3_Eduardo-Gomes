PGDMP         3                x            SistemaEniatus    12.4    12.4     .           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            /           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            0           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            1           1262    41101    SistemaEniatus    DATABASE     �   CREATE DATABASE "SistemaEniatus" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Portuguese_Brazil.1252' LC_CTYPE = 'Portuguese_Brazil.1252';
     DROP DATABASE "SistemaEniatus";
                postgres    false            �            1259    51328    hibernate_sequence    SEQUENCE     {   CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.hibernate_sequence;
       public          postgres    false            �            1259    51330    mesdereferencia    TABLE     �   CREATE TABLE public.mesdereferencia (
    id bigint NOT NULL,
    descricao character varying(255),
    idinss bigint,
    idirrf bigint,
    idsalariofamilia bigint,
    idsalariominimo bigint
);
 #   DROP TABLE public.mesdereferencia;
       public         heap    postgres    false            �            1259    51335    pessoa    TABLE     �  CREATE TABLE public.pessoa (
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
       public         heap    postgres    false            �            1259    51343    requestresetsenha    TABLE     �   CREATE TABLE public.requestresetsenha (
    id bigint NOT NULL,
    datarequest timestamp without time zone,
    idpessoa bigint
);
 %   DROP TABLE public.requestresetsenha;
       public         heap    postgres    false            �            1259    51348 
   tabelainss    TABLE     �   CREATE TABLE public.tabelainss (
    id bigint NOT NULL,
    aliquota double precision,
    valormaximo double precision,
    valorminimo double precision,
    vigencia timestamp without time zone
);
    DROP TABLE public.tabelainss;
       public         heap    postgres    false            �            1259    51353 
   tabelairrf    TABLE     �   CREATE TABLE public.tabelairrf (
    id bigint NOT NULL,
    aliquota double precision,
    valordeduzir double precision,
    valormaximo double precision,
    valorminimo double precision,
    vigencia timestamp without time zone
);
    DROP TABLE public.tabelairrf;
       public         heap    postgres    false            �            1259    51358    tabelasalariofamilia    TABLE     �   CREATE TABLE public.tabelasalariofamilia (
    id bigint NOT NULL,
    remuneracaomensal double precision,
    valorunitario double precision,
    vigencia timestamp without time zone
);
 (   DROP TABLE public.tabelasalariofamilia;
       public         heap    postgres    false            �            1259    51363    tabelasalariominimo    TABLE     �   CREATE TABLE public.tabelasalariominimo (
    id bigint NOT NULL,
    valor double precision,
    vigencia timestamp without time zone
);
 '   DROP TABLE public.tabelasalariominimo;
       public         heap    postgres    false            %          0    51330    mesdereferencia 
   TABLE DATA           k   COPY public.mesdereferencia (id, descricao, idinss, idirrf, idsalariofamilia, idsalariominimo) FROM stdin;
    public          postgres    false    203   7        &          0    51335    pessoa 
   TABLE DATA           �   COPY public.pessoa (id, dataadmissao, datanascimento, funcao, horassemanaiscontratadas, naturalidade, nome, qntfilhos, senha, sindicalizado, tipo, usuario) FROM stdin;
    public          postgres    false    204   T        '          0    51343    requestresetsenha 
   TABLE DATA           F   COPY public.requestresetsenha (id, datarequest, idpessoa) FROM stdin;
    public          postgres    false    205   �"       (          0    51348 
   tabelainss 
   TABLE DATA           V   COPY public.tabelainss (id, aliquota, valormaximo, valorminimo, vigencia) FROM stdin;
    public          postgres    false    206   �"       )          0    51353 
   tabelairrf 
   TABLE DATA           d   COPY public.tabelairrf (id, aliquota, valordeduzir, valormaximo, valorminimo, vigencia) FROM stdin;
    public          postgres    false    207   #       *          0    51358    tabelasalariofamilia 
   TABLE DATA           ^   COPY public.tabelasalariofamilia (id, remuneracaomensal, valorunitario, vigencia) FROM stdin;
    public          postgres    false    208   5#       +          0    51363    tabelasalariominimo 
   TABLE DATA           B   COPY public.tabelasalariominimo (id, valor, vigencia) FROM stdin;
    public          postgres    false    209   R#       2           0    0    hibernate_sequence    SEQUENCE SET     A   SELECT pg_catalog.setval('public.hibernate_sequence', 21, true);
          public          postgres    false    202            �
           2606    51334 $   mesdereferencia mesdereferencia_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public.mesdereferencia
    ADD CONSTRAINT mesdereferencia_pkey PRIMARY KEY (id);
 N   ALTER TABLE ONLY public.mesdereferencia DROP CONSTRAINT mesdereferencia_pkey;
       public            postgres    false    203            �
           2606    51342    pessoa pessoa_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.pessoa
    ADD CONSTRAINT pessoa_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.pessoa DROP CONSTRAINT pessoa_pkey;
       public            postgres    false    204            �
           2606    51347 (   requestresetsenha requestresetsenha_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY public.requestresetsenha
    ADD CONSTRAINT requestresetsenha_pkey PRIMARY KEY (id);
 R   ALTER TABLE ONLY public.requestresetsenha DROP CONSTRAINT requestresetsenha_pkey;
       public            postgres    false    205            �
           2606    51352    tabelainss tabelainss_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.tabelainss
    ADD CONSTRAINT tabelainss_pkey PRIMARY KEY (id);
 D   ALTER TABLE ONLY public.tabelainss DROP CONSTRAINT tabelainss_pkey;
       public            postgres    false    206            �
           2606    51357    tabelairrf tabelairrf_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.tabelairrf
    ADD CONSTRAINT tabelairrf_pkey PRIMARY KEY (id);
 D   ALTER TABLE ONLY public.tabelairrf DROP CONSTRAINT tabelairrf_pkey;
       public            postgres    false    207            �
           2606    51362 .   tabelasalariofamilia tabelasalariofamilia_pkey 
   CONSTRAINT     l   ALTER TABLE ONLY public.tabelasalariofamilia
    ADD CONSTRAINT tabelasalariofamilia_pkey PRIMARY KEY (id);
 X   ALTER TABLE ONLY public.tabelasalariofamilia DROP CONSTRAINT tabelasalariofamilia_pkey;
       public            postgres    false    208            �
           2606    51367 ,   tabelasalariominimo tabelasalariominimo_pkey 
   CONSTRAINT     j   ALTER TABLE ONLY public.tabelasalariominimo
    ADD CONSTRAINT tabelasalariominimo_pkey PRIMARY KEY (id);
 V   ALTER TABLE ONLY public.tabelasalariominimo DROP CONSTRAINT tabelasalariominimo_pkey;
       public            postgres    false    209            %      x������ � �      &   z  x�}�Mn�@�ףS�H9?�5i��h��:��S` � 9��:=J/V*�S[��0�7����؁i���(c��9���Z�fzzNu�����n�ж�d�O�}3`x���(��c�lAp\\��h~��]z�)ob��B{b�s����O�q��
��_���d�$�\bc�B�"����s�ݨ��$iQ�N�2�ֺ��Aк�Ar��ͳ~$���hK,���\v�K)���g�m��c�έ1��[��z�ZgFbߍx���?��9y
�6�1��Օ�
T��|t�a��+ �A�'�F������2<�<4iW��G�����m֢4`��cQ�"x�EX�O��ڴv�}n��jpB�㥤�F'$)�y�+5���0�u���1v�'���RX����ž��Rf����\��U�����JkЂ�#���4�Nz�ػ��Ҵ�x�9m�T�����3f#��	�}�����}�/i��2͘����8��cL�2֌c�4�oR:�+
��>��@qS}���s��v8����<�pd��mS�T/�����js��1ر�ZF�Eo_o��ph������HN&ypZ�PF��,.�l��|(nIRqY�O�!�������ۘb      '      x������ � �      (      x������ � �      )      x������ � �      *      x������ � �      +      x������ � �     