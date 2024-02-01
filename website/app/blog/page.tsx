import { Box, Image, Text, Flex, Grid, Heading } from '@chakra-ui/react'
interface ArticleCardProps {
  title: string
  articleExcerpt: string
  author: string
  publishedDate: string
}

function ArticleCard(props: ArticleCardProps) {
  return (
    <Flex
      width='100%'
      border='1px solid'
      borderColor='gray.300'
      flexDirection='column'
      borderRadius='12px'
      overflow='clip'
      _hover={{ borderColor: 'black' }}
    >
      <a href='google.com' style={{ overflow: 'clip' }}>
        <Image src='https://picsum.photos/600/300' transition='transform 0.2s' />

        <Flex flexDirection='column' padding='16px' gap='8px' background='white' overflow='clip'>
          <Heading as='h2' fontWeight='600' fontSize='24px'>
            {props.title}
          </Heading>

          <Text noOfLines={4}>{props.articleExcerpt}</Text>

          <Flex gap='8px' alignItems='center' marginTop='10px'>
            <Box height='30px' borderRadius='999px' width='30px' background='gray' />

            <Flex flexDirection='column'>
              <Text fontSize='12px' fontWeight='normal'>
                {props.author}
              </Text>
              <Text as='time' fontSize='12px' fontWeight='normal'>
                {props.publishedDate}
              </Text>
            </Flex>
          </Flex>
        </Flex>
      </a>
    </Flex>
  )
}

function FeaturedArticle(props: ArticleCardProps) {
  return (
    <Flex gap='32px' flexDirection={{ base: 'column', lg: 'row' }}>
      <a href='google.com' style={{ overflow: 'clip', borderRadius: '12px' }}>
        <Image
          src='https://picsum.photos/600/300'
          transition='transform 0.2s'
          width={{ base: '100%', lg: undefined }}
        />
      </a>

      <Flex flexDirection='column' justifyContent='space-evenly' width='560px' gap={{ base: '8px', lg: '0px' }}>
        <Heading as='h1' fontWeight='600' fontSize='48px'>
          {props.title}
        </Heading>
        <Text noOfLines={4}>{props.articleExcerpt}</Text>

        <Flex gap='8px' alignItems='center' marginTop={{ base: '10px', lg: '0px' }}>
          <Box height='30px' borderRadius='999px' width='30px' background='gray' />

          <Flex flexDirection='column'>
            <Text fontSize='12px' fontWeight='normal'>
              {props.author}
            </Text>
            <Text as='time' fontSize='12px' fontWeight='normal'>
              {props.publishedDate}
            </Text>
          </Flex>
        </Flex>
      </Flex>
    </Flex>
  )
}

const excerpt =
  "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of 'de Finibus Bonorum et Malorum' (The Extremes of Good and Evil) by Cicero"

export default function BlogPage() {
  return (
    <Flex as='main' justifyContent='center' margin='32px'>
      <Flex width='1280px' flexDirection='column' gap='48px'>
        <FeaturedArticle
          title='First Article'
          author='tomdoeslinux'
          publishedDate='Jan 2, 2024'
          articleExcerpt={excerpt}
        />

        <Grid gridTemplateColumns={{ base: 'repeat(1, 1fr)', md: 'repeat(2, 1fr)', lg: 'repeat(3, 1fr)' }} gap='20px'>
          {[...Array(12)].map((num) => (
            <ArticleCard
              key={num}
              title='First Article'
              publishedDate='Jan 2, 2024'
              author='tomdoeslinux'
              articleExcerpt={excerpt}
            />
          ))}
        </Grid>
      </Flex>
    </Flex>
  )
}