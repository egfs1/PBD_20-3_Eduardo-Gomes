PGDMP                     	    x            SistemaEniatus    12.4    12.4 '    K           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            L           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            M           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            N           1262    41101    SistemaEniatus    DATABASE     �   CREATE DATABASE "SistemaEniatus" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Portuguese_Brazil.1252' LC_CTYPE = 'Portuguese_Brazil.1252';
     DROP DATABASE "SistemaEniatus";
                postgres    false            �            1259    58284    folhadepagamento    TABLE     �  CREATE TABLE public.folhadepagamento (
    id bigint NOT NULL,
    acrescimodescricao character varying(255),
    acrescimovalor double precision NOT NULL,
    adicionaltemposervico double precision NOT NULL,
    auxilioalimentacao double precision NOT NULL,
    contribuicaosindical double precision NOT NULL,
    descontodescricao character varying(255),
    descontovalor double precision NOT NULL,
    faltas double precision NOT NULL,
    horaextra double precision NOT NULL,
    inss double precision NOT NULL,
    irrf double precision NOT NULL,
    salariobase double precision NOT NULL,
    salariofamilia double precision NOT NULL,
    salarioliquido double precision NOT NULL,
    user_id bigint,
    vigencia timestamp without time zone
);
 $   DROP TABLE public.folhadepagamento;
       public         heap    postgres    false            �            1259    58282    hibernate_sequence    SEQUENCE     {   CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.hibernate_sequence;
       public          postgres    false            �            1259    58292    log    TABLE     |   CREATE TABLE public.log (
    id bigint NOT NULL,
    data timestamp without time zone,
    texto character varying(255)
);
    DROP TABLE public.log;
       public         heap    postgres    false            �            1259    58297    mesdereferencia    TABLE     �   CREATE TABLE public.mesdereferencia (
    id bigint NOT NULL,
    idinss bigint,
    idirrf bigint,
    idsalariofamilia bigint,
    idsalariominimo bigint,
    vigencia timestamp without time zone
);
 #   DROP TABLE public.mesdereferencia;
       public         heap    postgres    false            �            1259    58302    pessoa    TABLE     �  CREATE TABLE public.pessoa (
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
    usuario character varying(255),
    valorhora double precision
);
    DROP TABLE public.pessoa;
       public         heap    postgres    false            �            1259    58310    requestresetsenha    TABLE     �   CREATE TABLE public.requestresetsenha (
    id bigint NOT NULL,
    datarequest timestamp without time zone,
    idpessoa bigint
);
 %   DROP TABLE public.requestresetsenha;
       public         heap    postgres    false            �            1259    58315 
   tabelainss    TABLE     �   CREATE TABLE public.tabelainss (
    id bigint NOT NULL,
    idvalorinss1 bigint,
    idvalorinss2 bigint,
    idvalorinss3 bigint,
    idvalorinss4 bigint,
    vigencia timestamp without time zone
);
    DROP TABLE public.tabelainss;
       public         heap    postgres    false            �            1259    58320 
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
       public         heap    postgres    false            �            1259    58325    tabelasalariofamilia    TABLE     �   CREATE TABLE public.tabelasalariofamilia (
    id bigint NOT NULL,
    remuneracaomensal double precision,
    valorunitario double precision,
    vigencia timestamp without time zone
);
 (   DROP TABLE public.tabelasalariofamilia;
       public         heap    postgres    false            �            1259    58330    tabelasalariominimo    TABLE     �   CREATE TABLE public.tabelasalariominimo (
    id bigint NOT NULL,
    valor double precision,
    vigencia timestamp without time zone
);
 '   DROP TABLE public.tabelasalariominimo;
       public         heap    postgres    false            �            1259    58335    valoresinss    TABLE     �   CREATE TABLE public.valoresinss (
    id bigint NOT NULL,
    aliquota double precision,
    valormaximo double precision,
    valorminimo double precision
);
    DROP TABLE public.valoresinss;
       public         heap    postgres    false            �            1259    58340    valoresirrf    TABLE     �   CREATE TABLE public.valoresirrf (
    id bigint NOT NULL,
    aliquota double precision,
    valordeduzir double precision,
    valormaximo double precision,
    valorminimo double precision
);
    DROP TABLE public.valoresirrf;
       public         heap    postgres    false            >          0    58284    folhadepagamento 
   TABLE DATA             COPY public.folhadepagamento (id, acrescimodescricao, acrescimovalor, adicionaltemposervico, auxilioalimentacao, contribuicaosindical, descontodescricao, descontovalor, faltas, horaextra, inss, irrf, salariobase, salariofamilia, salarioliquido, user_id, vigencia) FROM stdin;
    public          postgres    false    203   	1       ?          0    58292    log 
   TABLE DATA           .   COPY public.log (id, data, texto) FROM stdin;
    public          postgres    false    204   p1       @          0    58297    mesdereferencia 
   TABLE DATA           j   COPY public.mesdereferencia (id, idinss, idirrf, idsalariofamilia, idsalariominimo, vigencia) FROM stdin;
    public          postgres    false    205   �2       A          0    58302    pessoa 
   TABLE DATA           �   COPY public.pessoa (id, dataadmissao, datanascimento, funcao, horassemanaiscontratadas, naturalidade, nome, qntfilhos, senha, sindicalizado, tipo, usuario, valorhora) FROM stdin;
    public          postgres    false    206   63       B          0    58310    requestresetsenha 
   TABLE DATA           F   COPY public.requestresetsenha (id, datarequest, idpessoa) FROM stdin;
    public          postgres    false    207   �3       C          0    58315 
   tabelainss 
   TABLE DATA           j   COPY public.tabelainss (id, idvalorinss1, idvalorinss2, idvalorinss3, idvalorinss4, vigencia) FROM stdin;
    public          postgres    false    208   �3       D          0    58320 
   tabelairrf 
   TABLE DATA           x   COPY public.tabelairrf (id, idvalorirrf1, idvalorirrf2, idvalorirrf3, idvalorirrf4, idvalorirrf5, vigencia) FROM stdin;
    public          postgres    false    209   4       E          0    58325    tabelasalariofamilia 
   TABLE DATA           ^   COPY public.tabelasalariofamilia (id, remuneracaomensal, valorunitario, vigencia) FROM stdin;
    public          postgres    false    210   R4       F          0    58330    tabelasalariominimo 
   TABLE DATA           B   COPY public.tabelasalariominimo (id, valor, vigencia) FROM stdin;
    public          postgres    false    211   �4       G          0    58335    valoresinss 
   TABLE DATA           M   COPY public.valoresinss (id, aliquota, valormaximo, valorminimo) FROM stdin;
    public          postgres    false    212   �4       H          0    58340    valoresirrf 
   TABLE DATA           [   COPY public.valoresirrf (id, aliquota, valordeduzir, valormaximo, valorminimo) FROM stdin;
    public          postgres    false    213   5       O           0    0    hibernate_sequence    SEQUENCE SET     A   SELECT pg_catalog.setval('public.hibernate_sequence', 52, true);
          public          postgres    false    202            �
           2606    58291 &   folhadepagamento folhadepagamento_pkey 
   CONSTRAINT     d   ALTER TABLE ONLY public.folhadepagamento
    ADD CONSTRAINT folhadepagamento_pkey PRIMARY KEY (id);
 P   ALTER TABLE ONLY public.folhadepagamento DROP CONSTRAINT folhadepagamento_pkey;
       public            postgres    false    203            �
           2606    58296    log log_pkey 
   CONSTRAINT     J   ALTER TABLE ONLY public.log
    ADD CONSTRAINT log_pkey PRIMARY KEY (id);
 6   ALTER TABLE ONLY public.log DROP CONSTRAINT log_pkey;
       public            postgres    false    204            �
           2606    58301 $   mesdereferencia mesdereferencia_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public.mesdereferencia
    ADD CONSTRAINT mesdereferencia_pkey PRIMARY KEY (id);
 N   ALTER TABLE ONLY public.mesdereferencia DROP CONSTRAINT mesdereferencia_pkey;
       public            postgres    false    205            �
           2606    58309    pessoa pessoa_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.pessoa
    ADD CONSTRAINT pessoa_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.pessoa DROP CONSTRAINT pessoa_pkey;
       public            postgres    false    206            �
           2606    58314 (   requestresetsenha requestresetsenha_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY public.requestresetsenha
    ADD CONSTRAINT requestresetsenha_pkey PRIMARY KEY (id);
 R   ALTER TABLE ONLY public.requestresetsenha DROP CONSTRAINT requestresetsenha_pkey;
       public            postgres    false    207            �
           2606    58319    tabelainss tabelainss_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.tabelainss
    ADD CONSTRAINT tabelainss_pkey PRIMARY KEY (id);
 D   ALTER TABLE ONLY public.tabelainss DROP CONSTRAINT tabelainss_pkey;
       public            postgres    false    208            �
           2606    58324    tabelairrf tabelairrf_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.tabelairrf
    ADD CONSTRAINT tabelairrf_pkey PRIMARY KEY (id);
 D   ALTER TABLE ONLY public.tabelairrf DROP CONSTRAINT tabelairrf_pkey;
       public            postgres    false    209            �
           2606    58329 .   tabelasalariofamilia tabelasalariofamilia_pkey 
   CONSTRAINT     l   ALTER TABLE ONLY public.tabelasalariofamilia
    ADD CONSTRAINT tabelasalariofamilia_pkey PRIMARY KEY (id);
 X   ALTER TABLE ONLY public.tabelasalariofamilia DROP CONSTRAINT tabelasalariofamilia_pkey;
       public            postgres    false    210            �
           2606    58334 ,   tabelasalariominimo tabelasalariominimo_pkey 
   CONSTRAINT     j   ALTER TABLE ONLY public.tabelasalariominimo
    ADD CONSTRAINT tabelasalariominimo_pkey PRIMARY KEY (id);
 V   ALTER TABLE ONLY public.tabelasalariominimo DROP CONSTRAINT tabelasalariominimo_pkey;
       public            postgres    false    211            �
           2606    58339    valoresinss valoresinss_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.valoresinss
    ADD CONSTRAINT valoresinss_pkey PRIMARY KEY (id);
 F   ALTER TABLE ONLY public.valoresinss DROP CONSTRAINT valoresinss_pkey;
       public            postgres    false    212            �
           2606    58344    valoresirrf valoresirrf_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.valoresirrf
    ADD CONSTRAINT valoresirrf_pkey PRIMARY KEY (id);
 F   ALTER TABLE ONLY public.valoresirrf DROP CONSTRAINT valoresirrf_pkey;
       public            postgres    false    213            >   W   x�M���0k{
��6f�A$-A����������Q�A Eu��\�B�֦j����s�>�Fj����d0E�6��0���      ?   |  x���1R�0E��*�@h�+[�������f���f�S�bHI�&͸�G�Y��+��~��4Ҁ�I+�f�����O2��~�wp/ס�n��2ȏ~s<��>HЏ!�I.a8~�=����o'a9��Y��ޅ��  8=�����.��!�~\���7���[���	s�I"c���L��蜆�Cy��E�Qα����0�\:ҥa��n�B&��M��q7��N�ȕ�>�L�yƱM�vJ$�|��z�
Jk�k+��te�jy?��ԨZ���IfE�Z-�Q�+��6he]UTK�Rؤ+eC&^)ҹRh�6�x�r�*Wv�T���)�U�����d�m�K��Py�:N�^��X6C���y[+Kec���ԅB/J�@w�      @   *   x�32�44�44�4�4�4202�54�50T00�#�=... u�      A   x   x�M�1!F���^��̀a�� ��fHH�%������W��1���<��p�Y����\ӫ�u]S�p�G�Q�\{CNo���BX�	^/�zg����ӕ�<-
ny�͓B�O��/Ƙ�m%3      B      x������ � �      C   (   x�34�4�4���4202�54�50T00�#�=... h��      D   /   x�34�44�44�44�44�44�4202�54�50T00�#�=... �Z�      E   -   x�3�4412�35�4��33�4202�54�50T00�#�=... �C�      F   $   x�3�4400�4202�54�50T00�#�=... Y�L      G   :   x�-��  �w2L�@9��ρ���K�.Z��|�07���S��,8_�#���c      H   X   x�-�� 1�P�tH/�K���������-hI��K��C��lIV��b���s�ܧ���Hy�W�3����+4��?��     