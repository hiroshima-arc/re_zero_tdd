require 'sinatra'
require_relative './movie'
require_relative './rental'
require_relative './customer'

before do
  if !request.body.read.empty? && !request.body.empty?
    request.body.rewind
    @params = Sinatra::IndifferentHash.new
    @params.merge!(JSON.parse(request.body.read))
  end
end

##################################
# Return a Hello world JSON
##################################
get '/api/hello-world' do
  content_type :json
  headers 'Access-Control-Allow-Origin' => '*'

  content_type :json
  { Output: 'Hello World!' }.to_json
end

post '/api/hello-world' do
  content_type :json
  headers 'Access-Control-Allow-Origin' => '*'

  content_type :json
  { Output: 'Hello World!' }.to_json
end

get '/api/statement' do
  new_release_movie = Movie.new('新作', Movie::NEW_RELEASE)
  children_movie = Movie.new('子供', Movie::CHILDREN)
  regular_movie = Movie.new('一般', Movie::REGULAR)

  new_release = Rental.new(new_release_movie, 3)
  children = Rental.new(children_movie, 2)
  regular = Rental.new(regular_movie, 1)

  customer = Customer.new('山田')
  customer.add_rental(new_release)
  customer.add_rental(children)
  customer.add_rental(regular)

  content_type :json
  headers 'Access-Control-Allow-Origin' => '*'
  { statement: customer.statement }.to_json
end
